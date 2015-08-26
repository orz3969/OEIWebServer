package com.oeinetwork.Utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

/**
 * Created by scotg_000 on 2015/7/15
 */
public class PictureCode extends HttpServlet {
    private static final int WIDTH = 80;
    private static final int HEIGHT = 35;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("image/jpeg");
        ServletOutputStream sos = resp.getOutputStream();

        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        char[] rands = generateCheckCode();
        drawBackground(g);
        drawRands(g, rands);
        g.dispose();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", bos);
        byte[] buf = bos.toByteArray();
        resp.setContentLength(buf.length);
        sos.write(buf);
        bos.close();
        sos.close();
        session.setAttribute("randomCode", new String(rands));
    }

    private char[] generateCheckCode() {
        String chars = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";
        char[] rands = new char[4];
        for (int i = 0; i < 4; i++) {
            int rand = (int) (Math.random() * 34);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

    private void drawRands(Graphics g, char[] rands) {
        // g.setColor(Color.BLUE);
        Random random = new Random();
        int red, green, blue;
        int locationX[] = {10, 30, 52, 62};
        int locationY[] = {20, 19, 23, 21};
        g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
        for (int i = 0; i < 4; i++) {
            red = random.nextInt(200);
            green = random.nextInt(200);
            blue = random.nextInt(200);
            g.setColor(new Color(red, green, blue));
            g.drawString("" + rands[i], locationX[i], locationY[i]);
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (int i = 0; i < 120; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            g.setColor(new Color(red, green, blue));
            g.drawOval(x, y, 1, 1);
        }
    }
}
