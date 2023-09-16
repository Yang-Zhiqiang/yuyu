package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.db.entity.BT_KawaseRateData;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KwsrendouKbn;

/**
 * 為替レートデータテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_KawaseRateData extends AbstractExDBTable<BT_KawaseRateData> {

    public GenQBT_KawaseRateData() {
        this("BT_KawaseRateData");
    }

    public GenQBT_KawaseRateData(String pAlias) {
        super("BT_KawaseRateData", BT_KawaseRateData.class, pAlias);
    }

    public String BT_KawaseRateData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_KawaseRateData, BizDate> kwsratekjymd = new ExDBFieldString<>("kwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<BT_KawaseRateData, C_KwsrendouKbn> kwsrendoukbn = new ExDBFieldString<>("kwsrendoukbn", this, UserType_C_KwsrendouKbn.class);

    public final ExDBFieldString<BT_KawaseRateData, String> yobiv91 = new ExDBFieldString<>("yobiv91", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpytts = new ExDBFieldNumber<>("usdjpytts", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpyttb = new ExDBFieldNumber<>("usdjpyttb", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpyttm = new ExDBFieldNumber<>("usdjpyttm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpytts = new ExDBFieldNumber<>("eurjpytts", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpyttb = new ExDBFieldNumber<>("eurjpyttb", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpyttm = new ExDBFieldNumber<>("eurjpyttm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpytts = new ExDBFieldNumber<>("audjpytts", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpyttb = new ExDBFieldNumber<>("audjpyttb", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpyttm = new ExDBFieldNumber<>("audjpyttm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9 = new ExDBFieldNumber<>("yobin9", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x2 = new ExDBFieldNumber<>("yobin9x2", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x3 = new ExDBFieldNumber<>("yobin9x3", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x4 = new ExDBFieldNumber<>("yobin9x4", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x5 = new ExDBFieldNumber<>("yobin9x5", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x6 = new ExDBFieldNumber<>("yobin9x6", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x7 = new ExDBFieldNumber<>("yobin9x7", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x8 = new ExDBFieldNumber<>("yobin9x8", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x9 = new ExDBFieldNumber<>("yobin9x9", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x10 = new ExDBFieldNumber<>("yobin9x10", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x11 = new ExDBFieldNumber<>("yobin9x11", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x12 = new ExDBFieldNumber<>("yobin9x12", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x13 = new ExDBFieldNumber<>("yobin9x13", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x14 = new ExDBFieldNumber<>("yobin9x14", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x15 = new ExDBFieldNumber<>("yobin9x15", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x16 = new ExDBFieldNumber<>("yobin9x16", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x17 = new ExDBFieldNumber<>("yobin9x17", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x18 = new ExDBFieldNumber<>("yobin9x18", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x19 = new ExDBFieldNumber<>("yobin9x19", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x20 = new ExDBFieldNumber<>("yobin9x20", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x21 = new ExDBFieldNumber<>("yobin9x21", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpynykn = new ExDBFieldNumber<>("usdjpynykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpynykn = new ExDBFieldNumber<>("eurjpynykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpynykn = new ExDBFieldNumber<>("audjpynykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x101 = new ExDBFieldNumber<>("yobin9x101", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x102 = new ExDBFieldNumber<>("yobin9x102", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x103 = new ExDBFieldNumber<>("yobin9x103", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x104 = new ExDBFieldNumber<>("yobin9x104", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x105 = new ExDBFieldNumber<>("yobin9x105", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x106 = new ExDBFieldNumber<>("yobin9x106", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x107 = new ExDBFieldNumber<>("yobin9x107", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdeurnykn = new ExDBFieldNumber<>("usdeurnykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdaudnykn = new ExDBFieldNumber<>("usdaudnykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x111 = new ExDBFieldNumber<>("yobin9x111", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x112 = new ExDBFieldNumber<>("yobin9x112", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x113 = new ExDBFieldNumber<>("yobin9x113", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x114 = new ExDBFieldNumber<>("yobin9x114", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x115 = new ExDBFieldNumber<>("yobin9x115", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x116 = new ExDBFieldNumber<>("yobin9x116", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x117 = new ExDBFieldNumber<>("yobin9x117", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurusdnykn = new ExDBFieldNumber<>("eurusdnykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> euraudnykn = new ExDBFieldNumber<>("euraudnykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x121 = new ExDBFieldNumber<>("yobin9x121", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x122 = new ExDBFieldNumber<>("yobin9x122", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x123 = new ExDBFieldNumber<>("yobin9x123", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x124 = new ExDBFieldNumber<>("yobin9x124", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x125 = new ExDBFieldNumber<>("yobin9x125", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x126 = new ExDBFieldNumber<>("yobin9x126", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x127 = new ExDBFieldNumber<>("yobin9x127", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audusdnykn = new ExDBFieldNumber<>("audusdnykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audeurnykn = new ExDBFieldNumber<>("audeurnykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x131 = new ExDBFieldNumber<>("yobin9x131", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x132 = new ExDBFieldNumber<>("yobin9x132", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x133 = new ExDBFieldNumber<>("yobin9x133", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x134 = new ExDBFieldNumber<>("yobin9x134", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x135 = new ExDBFieldNumber<>("yobin9x135", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x136 = new ExDBFieldNumber<>("yobin9x136", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x137 = new ExDBFieldNumber<>("yobin9x137", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x141 = new ExDBFieldNumber<>("yobin9x141", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x142 = new ExDBFieldNumber<>("yobin9x142", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x143 = new ExDBFieldNumber<>("yobin9x143", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x144 = new ExDBFieldNumber<>("yobin9x144", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x145 = new ExDBFieldNumber<>("yobin9x145", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x146 = new ExDBFieldNumber<>("yobin9x146", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x147 = new ExDBFieldNumber<>("yobin9x147", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x148 = new ExDBFieldNumber<>("yobin9x148", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x149 = new ExDBFieldNumber<>("yobin9x149", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x151 = new ExDBFieldNumber<>("yobin9x151", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x152 = new ExDBFieldNumber<>("yobin9x152", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x153 = new ExDBFieldNumber<>("yobin9x153", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x154 = new ExDBFieldNumber<>("yobin9x154", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x155 = new ExDBFieldNumber<>("yobin9x155", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x156 = new ExDBFieldNumber<>("yobin9x156", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x157 = new ExDBFieldNumber<>("yobin9x157", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x158 = new ExDBFieldNumber<>("yobin9x158", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x159 = new ExDBFieldNumber<>("yobin9x159", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x161 = new ExDBFieldNumber<>("yobin9x161", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x162 = new ExDBFieldNumber<>("yobin9x162", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x163 = new ExDBFieldNumber<>("yobin9x163", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x164 = new ExDBFieldNumber<>("yobin9x164", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x165 = new ExDBFieldNumber<>("yobin9x165", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x166 = new ExDBFieldNumber<>("yobin9x166", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x167 = new ExDBFieldNumber<>("yobin9x167", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x168 = new ExDBFieldNumber<>("yobin9x168", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x169 = new ExDBFieldNumber<>("yobin9x169", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x171 = new ExDBFieldNumber<>("yobin9x171", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x172 = new ExDBFieldNumber<>("yobin9x172", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x173 = new ExDBFieldNumber<>("yobin9x173", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x174 = new ExDBFieldNumber<>("yobin9x174", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x175 = new ExDBFieldNumber<>("yobin9x175", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x176 = new ExDBFieldNumber<>("yobin9x176", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x177 = new ExDBFieldNumber<>("yobin9x177", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x178 = new ExDBFieldNumber<>("yobin9x178", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x179 = new ExDBFieldNumber<>("yobin9x179", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x181 = new ExDBFieldNumber<>("yobin9x181", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x182 = new ExDBFieldNumber<>("yobin9x182", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x183 = new ExDBFieldNumber<>("yobin9x183", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x184 = new ExDBFieldNumber<>("yobin9x184", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x185 = new ExDBFieldNumber<>("yobin9x185", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x186 = new ExDBFieldNumber<>("yobin9x186", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x187 = new ExDBFieldNumber<>("yobin9x187", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x188 = new ExDBFieldNumber<>("yobin9x188", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x189 = new ExDBFieldNumber<>("yobin9x189", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x191 = new ExDBFieldNumber<>("yobin9x191", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x192 = new ExDBFieldNumber<>("yobin9x192", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x193 = new ExDBFieldNumber<>("yobin9x193", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x194 = new ExDBFieldNumber<>("yobin9x194", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x195 = new ExDBFieldNumber<>("yobin9x195", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x196 = new ExDBFieldNumber<>("yobin9x196", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x197 = new ExDBFieldNumber<>("yobin9x197", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x198 = new ExDBFieldNumber<>("yobin9x198", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x199 = new ExDBFieldNumber<>("yobin9x199", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x201 = new ExDBFieldNumber<>("yobin9x201", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x202 = new ExDBFieldNumber<>("yobin9x202", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x203 = new ExDBFieldNumber<>("yobin9x203", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x204 = new ExDBFieldNumber<>("yobin9x204", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x205 = new ExDBFieldNumber<>("yobin9x205", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x206 = new ExDBFieldNumber<>("yobin9x206", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x207 = new ExDBFieldNumber<>("yobin9x207", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x208 = new ExDBFieldNumber<>("yobin9x208", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x209 = new ExDBFieldNumber<>("yobin9x209", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpysykn = new ExDBFieldNumber<>("usdjpysykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpysykn = new ExDBFieldNumber<>("eurjpysykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpysykn = new ExDBFieldNumber<>("audjpysykn", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x301 = new ExDBFieldNumber<>("yobin9x301", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x302 = new ExDBFieldNumber<>("yobin9x302", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x303 = new ExDBFieldNumber<>("yobin9x303", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x304 = new ExDBFieldNumber<>("yobin9x304", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x305 = new ExDBFieldNumber<>("yobin9x305", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x306 = new ExDBFieldNumber<>("yobin9x306", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x307 = new ExDBFieldNumber<>("yobin9x307", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpytts17pm = new ExDBFieldNumber<>("usdjpytts17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpyttb17pm = new ExDBFieldNumber<>("usdjpyttb17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> usdjpyttm17pm = new ExDBFieldNumber<>("usdjpyttm17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpytts17pm = new ExDBFieldNumber<>("eurjpytts17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpyttb17pm = new ExDBFieldNumber<>("eurjpyttb17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> eurjpyttm17pm = new ExDBFieldNumber<>("eurjpyttm17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpytts17pm = new ExDBFieldNumber<>("audjpytts17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpyttb17pm = new ExDBFieldNumber<>("audjpyttb17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> audjpyttm17pm = new ExDBFieldNumber<>("audjpyttm17pm", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x501 = new ExDBFieldNumber<>("yobin9x501", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x502 = new ExDBFieldNumber<>("yobin9x502", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x503 = new ExDBFieldNumber<>("yobin9x503", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x504 = new ExDBFieldNumber<>("yobin9x504", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x505 = new ExDBFieldNumber<>("yobin9x505", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x506 = new ExDBFieldNumber<>("yobin9x506", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x507 = new ExDBFieldNumber<>("yobin9x507", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x508 = new ExDBFieldNumber<>("yobin9x508", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x509 = new ExDBFieldNumber<>("yobin9x509", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x510 = new ExDBFieldNumber<>("yobin9x510", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x511 = new ExDBFieldNumber<>("yobin9x511", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x512 = new ExDBFieldNumber<>("yobin9x512", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x513 = new ExDBFieldNumber<>("yobin9x513", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x514 = new ExDBFieldNumber<>("yobin9x514", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x515 = new ExDBFieldNumber<>("yobin9x515", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x516 = new ExDBFieldNumber<>("yobin9x516", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x517 = new ExDBFieldNumber<>("yobin9x517", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x518 = new ExDBFieldNumber<>("yobin9x518", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x519 = new ExDBFieldNumber<>("yobin9x519", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x520 = new ExDBFieldNumber<>("yobin9x520", this);

    public final ExDBFieldNumber<BT_KawaseRateData, Double> yobin9x521 = new ExDBFieldNumber<>("yobin9x521", this);
}
