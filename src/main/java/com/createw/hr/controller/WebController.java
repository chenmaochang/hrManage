package com.createw.hr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.createw.hr.bean.User;
import com.createw.hr.service.TKnowledgeCategoryService;

@Controller
@RequestMapping("/web")
public class WebController {
	static final Logger LOGGER = LoggerFactory.getLogger(TKnowledgeCategoryController.class);
	
	
	@Resource
	TKnowledgeCategoryService tKnowledgeCategoryService;

	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		User user= (User) SecurityUtils.getSubject().getPrincipal();
		return new ModelAndView("home").addObject("name", user.getName());
	}

	@RequestMapping("/uploadFile")
	@ResponseBody
	public JSONObject uploadFile(MultipartFile file) {
		JSONObject rtnObj = new JSONObject();
		if (null != file) {
			String parentPath =  "/opt/vhosts/apache-tomcat-8.5.41/webapps/img";//"E:/file";
			String originalFileName = file.getOriginalFilename();
			String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + suffix;
			File fileDir = new File(parentPath);
			if (!fileDir.exists()) { // 如果不存在 则创建
				fileDir.mkdirs();
			}
			File localFile = new File(parentPath + "/" + fileName);
			try {
				file.transferTo(localFile);
				//testReadByDocx(localFile.getAbsolutePath());
				rtnObj.put("success", true);
				JSONObject dataObj = new JSONObject();
				dataObj.put("src", "http://wua.createt.cn:7777/img/" + fileName);
				dataObj.put("title", fileName);
				rtnObj.put("data", dataObj);
			} catch (Exception e) {
				rtnObj.put("code", 500);
				rtnObj.put("msg", "图片上传失败");
				e.printStackTrace();
			}
		} else {
			rtnObj.put("success", false);
		}
		return rtnObj;
	}

	public void testReadByDocx(String path) throws Exception {
		try (InputStream is = new FileInputStream(path);) {
			XWPFDocument doc = new XWPFDocument(is);
			XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
			String text = extractor.getText();
			System.out.println("开始读");
			System.out.println(text);
			List<XWPFParagraph> paras = doc.getParagraphs();
			for (XWPFParagraph para : paras) {
				// 当前段落的属性
				// CTPPr pr = para.getCTP().getPPr();
				System.out.println(para.getText());
			}
			// 获取文档中所有的表格
			List<XWPFTable> tables = doc.getTables();
			List<XWPFTableRow> rows;
			List<XWPFTableCell> cells;
			for (XWPFTable table : tables) {
				// 表格属性
				// CTTblPr pr = table.getCTTbl().getTblPr();
				// 获取表格对应的行
				rows = table.getRows();
				for (XWPFTableRow row : rows) {
					// 获取行对应的单元格
					cells = row.getTableCells();
					for (XWPFTableCell cell : cells) {
						System.out.println(cell.getText());
						;
					}
				}
			}
			System.out.println("读完了");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
