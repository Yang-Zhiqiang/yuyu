package yuyu.common.biz.workflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestUtil {

    public static final String nString_zenkaku(int cnt) {

        Random rnd = new Random();

        StringBuilder buf = new StringBuilder();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < cnt; i++) {
            list.add(rnd.nextInt(9));
        }
        Collections.shuffle(list);

        for (int j = 0; j < list.size(); j++) {
            buf.append(String.valueOf(list.get(j)));
        }

        return toBigAscii(buf.toString());
    }

    public static final String toBigAscii(String string) {
        if (string == null || string.length() <= 0) {
            return "";
        }
        StringBuilder buf = new StringBuilder();
        int len = string.length();
        for (int i = 0; i < len; i++) {
            buf.append(toBigAsciiOne(string.charAt(i)));
        }
        return buf.toString();
    }

    private static final String toBigAsciiOne(char code) {
        switch (code) {
            case '!':
                return "！";
            case '\"':
                return "”";
            case '#':
                return "＃";
            case '$':
                return "＄";
            case '\\':
                return "￥";
            case '%':
                return "％";
            case '&':
                return "＆";
            case '\'':
                return "’";
            case '(':
                return "（";
            case ')':
                return "）";
            case '*':
                return "＊";
            case '+':
                return "＋";
            case ',':
                return "，";
            case '-':
                return "－";
            case '.':
                return "．";
            case '/':
                return "／";
            case '0':
                return "０";
            case '1':
                return "１";
            case '2':
                return "２";
            case '3':
                return "３";
            case '4':
                return "４";
            case '5':
                return "５";
            case '6':
                return "６";
            case '7':
                return "７";
            case '8':
                return "８";
            case '9':
                return "９";
            case ':':
                return "：";
            case ';':
                return "；";
            case '<':
                return "＜";
            case '=':
                return "＝";
            case '>':
                return "＞";
            case '?':
                return "？";
            case '@':
                return "＠";
            case 'A':
                return "Ａ";
            case 'B':
                return "Ｂ";
            case 'C':
                return "Ｃ";
            case 'D':
                return "Ｄ";
            case 'E':
                return "Ｅ";
            case 'F':
                return "Ｆ";
            case 'G':
                return "Ｇ";
            case 'H':
                return "Ｈ";
            case 'I':
                return "Ｉ";
            case 'J':
                return "Ｊ";
            case 'K':
                return "Ｋ";
            case 'L':
                return "Ｌ";
            case 'M':
                return "Ｍ";
            case 'N':
                return "Ｎ";
            case 'O':
                return "Ｏ";
            case 'P':
                return "Ｐ";
            case 'Q':
                return "Ｑ";
            case 'R':
                return "Ｒ";
            case 'S':
                return "Ｓ";
            case 'T':
                return "Ｔ";
            case 'U':
                return "Ｕ";
            case 'V':
                return "Ｖ";
            case 'W':
                return "Ｗ";
            case 'X':
                return "Ｘ";
            case 'Y':
                return "Ｙ";
            case 'Z':
                return "Ｚ";
            case '^':
                return "＾";
            case '_':
                return "＿";
            case '`':
                return "‘";
            case 'a':
                return "ａ";
            case 'b':
                return "ｂ";
            case 'c':
                return "ｃ";
            case 'd':
                return "ｄ";
            case 'e':
                return "ｅ";
            case 'f':
                return "ｆ";
            case 'g':
                return "ｇ";
            case 'h':
                return "ｈ";
            case 'i':
                return "ｉ";
            case 'j':
                return "ｊ";
            case 'k':
                return "ｋ";
            case 'l':
                return "ｌ";
            case 'm':
                return "ｍ";
            case 'n':
                return "ｎ";
            case 'o':
                return "ｏ";
            case 'p':
                return "ｐ";
            case 'q':
                return "ｑ";
            case 'r':
                return "ｒ";
            case 's':
                return "ｓ";
            case 't':
                return "ｔ";
            case 'u':
                return "ｕ";
            case 'v':
                return "ｖ";
            case 'w':
                return "ｗ";
            case 'x':
                return "ｘ";
            case 'y':
                return "ｙ";
            case 'z':
                return "ｚ";
            case '{':
                return "｛";
            case '|':
                return "｜";
            case '}':
                return "｝";
            case '｡':
                return "。";
            case '｢':
                return "「";
            case '｣':
                return "」";
            case '､':
                return "、";
            case '･':
                return "・";
            case ' ':
                return "　";
        }
        return new String(new char[] { code });
    }

}
