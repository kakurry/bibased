/*
 * Copyright (c) 2015-2017 www.n22.com.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bibased.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFImageWriter;
import org.springframework.stereotype.Component;

/**
 * 利用pdfbox，将pdf转换为image
 * @author time 2017-03-23 17:03:23
 * @since 1.0
 */
@Component
public class Pdf2Image {

	/**
	 * 将无需的文件，转换为有序的文件
	 * @param files
	 * @return
	 */
	public static List<File> sort(List<File> files) {
		List<File> list = new ArrayList<File>(files.size());
		File dir = files.get(0).getParentFile();
		for(int i = 0; i < files.size(); i++) {
			list.add(new File(dir, String.format("%d.jpg", i)));
		}
		return list;
	}
	
	/**
	 * 将pdf转换为图片
	 * @param pdfFile PDF文件
	 * @param imageDir 存放图片的目录
	 * @param compress 压缩比例
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<File> conver(File pdfFile, File imageDir, float compress) {
		if(!pdfFile.exists()) {
			throw new IllegalArgumentException("文件未发现");
		}
		if(!imageDir.exists()) {
			imageDir.mkdirs();
		}
		
		List<File> imgFile = null;
		try {
			PDDocument pdf = null;
			try{
				pdf = PDDocument.load(pdfFile);
				List list = pdf.getDocumentCatalog().getAllPages();
				if(list != null && !list.isEmpty()) {
					imgFile = new ArrayList<File>(list.size());
					File one = null;
					for(int i = 0; i < list.size(); i++) {
						PDPage page = (PDPage) list.get(i); 
			            BufferedImage image = page.convertToImage();
			            one = new File(imageDir, String.format("%d.jpg", i));
			            if(compress != 1) {
			            	// 压缩
			            	int width = (int) (image.getWidth() * compress);
			            	int height = (int) (image.getHeight() * compress);
			            	BufferedImage small = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				            small.getGraphics().drawImage(image.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
				            ImageIO.write(small, "jpg", one);
			            } else {
			            	ImageIO.write(image, "jpg", one);
			            }
			            imgFile.add(one);
					}
				}
			} finally {
				if(pdf != null) {
					pdf.close();
				}
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		} 
		return imgFile;
	}
	
	public static void main(String[] args) throws Exception {
		Pdf2Image u = new Pdf2Image();
		List<File> list = u.conver(new File("C:\\Users\\Administrator\\Desktop\\文件上传资料\\建议书.pdf"), new File("/Users/time/Desktop/"), 1f);
		System.out.println(list);
		/*PDFImageWriter w = new PDFImageWriter();
		PDDocument pdf = PDDocument.load("C:\\\\Users\\\\Administrator\\\\Desktop\\\\文件上传资料\\\\建议书.pdf");
		w.writeImage(pdf, "jpg", null, 1, pdf.getNumberOfPages(), "/Users/time/Desktop/");*/
	}

}
