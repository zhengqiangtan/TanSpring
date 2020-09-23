package com.project.tan.common.util;


import com.google.common.collect.Lists;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * @DESC 邮件发送工具类
 * @Author tzq
 * @Date 2020-02-11 16:05
 **/
public class SendEmailUtil {
    public static Session getSession() {
        Properties prop = new Properties();
        prop.put("mail.host", "xxx");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.port", "25");
        //1.创建sesssion
        Session session = Session.getInstance(prop);
        //开启session的调试模式，可以查看当前邮件发送状态
        session.setDebug(false);
        return session;
    }

    public static void sendMessage(Message msg) throws Exception {
        Session session = getSession();

        //2.通过session获取Transport对象（发送邮件的核心API）
        Transport ts = session.getTransport();
        //3.通过邮件用户名密码链接
        ts.connect("alarm@xxxx.com", "xxxx");
        //4.创建邮件
        //5.发送电子邮件
        ts.sendMessage(msg, msg.getAllRecipients());
    }

    public static MimeMessage createSimpleMail(Session session, List<String> jobList, String tips) throws Exception {
        //创建邮件对象
        MimeMessage mm = new MimeMessage(session);
        //设置发件人
        mm.setFrom(new InternetAddress("alarm@xxx.com"));
        //设置收件人
        mm.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@xxx.com"));
//        mm.setRecipient(Message.RecipientType.TO, new InternetAddress("tan@qq.com"));
        //设置抄送人
//        mm.setRecipient(Message.RecipientType.CC, new InternetAddress(""));
        // 添加主题
        mm.setSubject("[告警]预警测试");


        // 添加邮件内容
        String head[] = {"ID", "用户", "任务名", "类型", "内存(MB)", "Vcore", "开始时间", "当前耗费时间(分)"};
        StringBuilder tableStart = getTableStart(head, "检测到大任务消耗资源明细如下：", tips);

        if (jobList.size() != 0) {
            for (int i = 0; i < jobList.size(); i++) {
                String record = jobList.get(i);
                String[] split = record.split("#");
                if (split.length != 0) {
                    String tr = "<tr class=\"odd\">";
                    if (i % 2 == 1) {
                        tr = "<tr class=\"even\">";
                    }
                    tableStart.append("     " + tr + "    ");
                    tableStart.append("         <td>" + split[0] + "</td>  ");
                    tableStart.append("         <td>" + split[1] + "</td>  ");
                    tableStart.append("         <td>" + split[2] + "</td>  ");
                    tableStart.append("         <td>" + split[3] + "</td>  ");
                    tableStart.append("         <td>" + split[4] + "</td>  ");
                    tableStart.append("         <td>" + split[5] + "</td>  ");
                    tableStart.append("         <td>" + split[6] + "</td>  ");
                    tableStart.append("         <td>" + split[7] + "</td>  ");
                    tableStart.append("       </tr>  ");
                }

            }
        }

        StringBuilder sb = getTableEnd(tableStart);

        mm.setContent(sb.toString(), "text/html;charset=utf-8");
        return mm;
    }


    public static StringBuilder getTableStart(String head[], String title, String tips) {

        StringBuilder table = new StringBuilder();
        table.append("    <html>");
        table.append("     <head>");
        table.append("      <title> QUERY BIG TASK  </title>");
        table.append("     </head>");
        table.append("    ");
        table.append("    <style type=\"text/css\">");
        table.append("    table { ");
        table.append("      margin: 10px 0 30px 0;");
        table.append("      font-size: 13px;");
        table.append("    }");
        table.append("    ");
        table.append("    table caption { ");
        table.append("      text-align:left;");
        table.append("    }");
        table.append("    ");
        table.append("    table tr th { ");
        table.append("      background: #3B3B3B;");
        table.append("      color: #FFF;");
        table.append("      padding: 7px 4px;");
        table.append("      text-align: left;");
        table.append("    }");
        table.append("    ");
        table.append("    table tr td { ");
        table.append("      color: #FFF;");
        table.append("      padding: 7px 4px;");
        table.append("      text-align: left;");
        table.append("    }");
        table.append("    ");
        table.append("    table tr.odd{");
        table.append("        background-color:#cef;");
        table.append("    }");
        table.append("    ");
        table.append("    table tr.even{");
        table.append("        background-color:#ffc;");
        table.append("    }");
        table.append("      ");
        table.append("    table tr td { ");
        table.append("      color: #47433F;");
        table.append("      border-top: 1px solid #FFF;");
        table.append("    }");
        table.append("     </style>");
        table.append("    ");
        table.append("     <body>");
        table.append("<h3>" + title + "<h3/>");
        table.append("<p>" + tips + "<p/>");
        table.append("    <table style=\"width:1200px; border-spacing:0;\">  ");
        table.append("       <tr>  ");
        for (int i = 0; i < head.length; i++) {
            table.append("          <th>" + head[i] + "</th>  ");
        }
        table.append("       </tr>  ");
        return table;
    }

    public static StringBuilder getTableEnd(StringBuilder table) {
        table.append("    </table> ");
        table.append("     </body>");
        table.append("    </html>");
        return table;
    }

    /**
     * 这里发送的是表格信息
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String tips = "xxx";
        List jobList = Lists.newArrayList();
        Session session = SendEmailUtil.getSession();
        MimeMessage simpleMail = SendEmailUtil.createSimpleMail(session, jobList, tips);
        SendEmailUtil.sendMessage(simpleMail);
        System.out.println("邮件发送成功！");
    }

}
