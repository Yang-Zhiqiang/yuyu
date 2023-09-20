package yuyu.common.suuri.srcommon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;

/**
 * 数理 数理共通 特定時点契約基本情報取得モード管理クラス
 */
public class SrGetTokutejitenKykKihonInfoModeManage {

    private static final String EDABAN1 = "_1";

    private static final String EDABAN2 = "_2";

    private static List<String> mode1ItemDefList = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.tikiktbrisyuruikbn");
        add("IT_KykKihon.hrkkeiro");
        add("IT_KykKihon.hrkkaisuu");
    }});

    private static List<String> mode2ItemDefList = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.tikiktbrisyuruikbn");
        add("IT_KykKihon.hrkkeiro");
    }});

    private static List<String> mode3ItemDefList1 = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.tikiktbrisyuruikbn");
    }});

    private static List<String> mode3ItemDefList2 = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.hrkkeiro");
    }});

    private static List<String> mode4ItemDefList1 = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.hrkkeiro");
    }});

    private static List<String> mode4ItemDefList2 = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.hrkkaisuu");
    }});

    private static List<String> mode5ItemDefList = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.hrkkeiro");
        add("IT_KykKihon.hrkkaisuu");
    }});

    private static List<String> mode6ItemDefList1 = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.hrkkaisuu");
    }});

    private static List<String> mode6ItemDefList2 = Collections.unmodifiableList(new ArrayList<String>() {{
        add("IT_KykKihon.hrkkeiro");
    }});

    public static Map<String, List<String>> modeManageMap =
        Collections.unmodifiableMap(new HashMap<String, List<String>>() {{
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN.getValue(), mode1ItemDefList);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNARI.getValue(), mode2ItemDefList);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI.getValue() + EDABAN1, mode3ItemDefList1);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI.getValue() + EDABAN2, mode3ItemDefList2);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNNASI_KAISUUHNARI.getValue() + EDABAN1, mode4ItemDefList1);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNNASI_KAISUUHNARI.getValue() + EDABAN2, mode4ItemDefList2);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_KAISUUHNARI.getValue(), mode5ItemDefList);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_KAISUUHNNASI.getValue() + EDABAN1, mode6ItemDefList1);
            put(C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_KAISUUHNNASI.getValue() + EDABAN2, mode6ItemDefList2);
        }});
}
