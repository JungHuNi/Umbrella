package com.ubr;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main {
    public static String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nodeValue =  (Node) nodeList.item(0);
        if (nodeValue == null){
            return null;
        }
        return nodeValue.getNodeValue();
    }


    public static void main(String[] args) {
        int page = 1;
        try{
            while(true){
                //parsing url지정
                String url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2?ServiceKey=uACKtH37bjww9PnSRExxpVteC3MSCff%2B2asi5o98J778lAyls0jEp%2FnLv29WZv3AeHNDOoFdNJ39kFu20eI58w%3D%3D" + page;
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document document = dBuilder.parse(url);

                document.getDocumentElement().normalize();
                System.out.println("Root element : " + document.getDocumentElement().getNodeName());

                NodeList nodeList = document.getElementsByTagName("base_date");
                System.out.println("파싱할 리스트 수 : " + nodeList.getLength());

                for (int temp = 0; temp < nodeList.getLength(); temp++){
                    Node node = nodeList.item(temp);

                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) node;
                        System.out.println("###################################");
                        System.out.println("갱신 날짜 : " + getTagValue("base_date", element));
                        System.out.println("시간 : " + getTagValue("base_time", element));
                        System.out.println("예보 지점 X : " + getTagValue("nx", element));
                        System.out.println("예보 지점 Y : " + getTagValue("ny", element));
                        System.out.println("데이터 타입 : " + getTagValue("_type", element));
                        System.out.println("###################################");
                    }
                }
                page += 1;
                System.out.println("페이지 : " + page);
                if (page > 10)
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
