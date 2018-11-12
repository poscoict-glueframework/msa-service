package com.poscoict.sample.sp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.poscoict.glueframework.schema.Service;
import com.poscoict.glueframework.schema.parser.GlueServiceParser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "REST API 유형 1", description = "로컬 File을 읽어서 GlueService(*-service.xml)를 제공합니다.", tags = {
		"REST API 유형 1" })
@RestController
@RequestMapping(value = "/glue-supports/file")
public class GlueServiceProviderFromFile {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${glue.sample.service.basedir:undefined}")
	private String baseDir;
	private URL url;

	@ApiOperation(value = "제공가능한 GlueService 목록")
	@GetMapping
	public List<String> getAvailableServiceNames() throws IOException {
		List<String> serviceNames = new ArrayList<>();
		if ("file".equals(this.url.getProtocol())) {
			File dir = new File(this.url.getPath());
			File[] list = dir.isFile() ? new File[] { dir } : dir.listFiles();
			for (File file : list) {
				String fileName = file.getName();
				serviceNames.add(fileName.substring(0, fileName.lastIndexOf(".")));
			}
		} else if ("jar".equals(this.url.getProtocol())) {
			String path = this.url.getPath();
			if (path != null && path.startsWith("file:")) {
				path = path.substring("file:".length());
			}
			path = URLDecoder.decode(path, "UTF-8");
			String filePath = path.substring(0, path.indexOf("!"));
			Enumeration<JarEntry> jarEntryList = new JarFile(new File(filePath)).entries();
			while (jarEntryList.hasMoreElements()) {
				JarEntry jarEntry = (JarEntry) jarEntryList.nextElement();
				String fileName = jarEntry.getName();
				if (fileName.endsWith("-service.xml")) {
					serviceNames.add(fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf(".")));
				}
			}
		} else {
			this.logger.warn("{} {}", this.url.getProtocol(), this.url.getPath());
		}
		return serviceNames;
	}

	@ApiOperation(value = "GlueService 조회하기")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "serviceName", value = "GlueService 명", required = true, dataType = "string", paramType = "path", defaultValue = "hello-service") })
	@GetMapping(path = "{serviceName}")
	public Service getGlueService(@PathVariable String serviceName) throws JAXBException, SAXException {
		String path = this.baseDir + File.separator + serviceName + ".xml";
		URL serviceXmlUrl = Thread.currentThread().getContextClassLoader().getResource(path);
		if (serviceXmlUrl == null) {
			String convertPath = path.replaceAll("\\\\", "/");
			serviceXmlUrl = Thread.currentThread().getContextClassLoader().getResource(convertPath);
		}
		this.logger.warn("{} {}", this.baseDir, serviceXmlUrl);
		return GlueServiceParser.parseXml(serviceXmlUrl);
	}

	@PostConstruct
	public void init() throws MalformedURLException {
		this.logger.info("{}", this.baseDir);
		if ("undefined".equals(this.baseDir)) {
			this.url = Thread.currentThread().getContextClassLoader().getResource("service");
			this.baseDir = "service";
		} else {
			this.url = new File(this.baseDir).toURI().toURL();
		}
		this.logger.info("{} {}", this.url.getProtocol(), this.url.getPath());
	}
}
