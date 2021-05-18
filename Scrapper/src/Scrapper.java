import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public  class Scrapper
{
    public static void linkParser(Elements links) //Helper function to extract links
    {
        for (Element link: links)
        {
            if (link.attr("href").startsWith("http"))
            {
                System.out.println((link.attr("href")));
            }
        }
    }
    public static void main(String[] args)
    {
        String url = "https://prefeitura.pbh.gov.br/saude/licitacao/pregao-eletronico-151-2020";

        try
        {
            Document document = Jsoup.connect(url).get(); //Connection to the URL
//            System.out.println(document.outerHtml()); This line prints whole HTML
            //Code to extract data using CSS selectors
            System.out.println(document.select(".lbl-licitacao:nth-child(1)").text());
            System.out.println(document.select(".lbl-licitacao:nth-child(13)").text());
            System.out.println(document.select(".lbl-licitacao:nth-child(19)").text());
            System.out.println(document.select(".lbl-licitacao:nth-child(4) ").text());
            System.out.println(document.select("p:nth-child(6)").text());
//            System.out.println(document.select("tr:nth-child(1) a[href]").get(1));


            //            Code to extract links using CSS selectors
            Elements links1 = document.select("tr:nth-child(1) a[href]");
            Elements links2 = document.select("tr:nth-child(2) a[href]");
            Elements links3 = document.select("tr:nth-child(3) a[href]");
            Elements links4 = document.select("tr:nth-child(4) a[href]");

            linkParser(links1);
            linkParser(links2);
            linkParser(links3);
            linkParser(links4);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}

//    CSS Selectors
// .lbl-licitacao:nth-child(1)
//         .lbl-licitacao:nth-child(13)
//         .lbl-licitacao:nth-child(19)
//
//         link 1 = tr:nth-child(1) a
//         link2 = tr:nth-child(2) a
//         link3 = tr:nth-child(3) a
//         link4 = tr:nth-child(4) a
