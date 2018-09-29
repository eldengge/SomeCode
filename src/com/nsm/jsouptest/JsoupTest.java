package com.nsm.jsouptest;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class JsoupTest {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.jma.go.jp/jp/gms/large.html?area=0&element=0").get();
		System.out.println(doc.html());
		Element element = doc.getElementById("image");
		System.out.println(element.attr("src"));
	}
}
