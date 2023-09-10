package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）未決管理システム連動レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiMktKnrRendouLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiMktKnrRendouLayoutFile() {
    }


    @Column(order = 1, label = "案件管理番号")
    private String ifcAnkenkanrino;


    public String getIfcAnkenkanrino() {
        return ifcAnkenkanrino;
    }


    public void setIfcAnkenkanrino(String pIfcAnkenkanrino) {
        ifcAnkenkanrino = pIfcAnkenkanrino;
    }


    @Column(order = 2, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 3, label = "依頼日")
    private BizDate ifcIraiymd;


    public BizDate getIfcIraiymd() {
        return ifcIraiymd;
    }


    public void setIfcIraiymd(BizDate pIfcIraiymd) {
        ifcIraiymd = pIfcIraiymd;
    }


    @Column(order = 4, label = "依頼元区分")
    private String ifcIraimotokbn;


    public String getIfcIraimotokbn() {
        return ifcIraimotokbn;
    }


    public void setIfcIraimotokbn(String pIfcIraimotokbn) {
        ifcIraimotokbn = pIfcIraimotokbn;
    }


    @Column(order = 5, label = "不備種別")
    private String ifcHubisyubetu;


    public String getIfcHubisyubetu() {
        return ifcHubisyubetu;
    }


    public void setIfcHubisyubetu(String pIfcHubisyubetu) {
        ifcHubisyubetu = pIfcHubisyubetu;
    }


    @Column(order = 6, label = "確認先区分")
    private String ifcKakuninsakikbn;


    public String getIfcKakuninsakikbn() {
        return ifcKakuninsakikbn;
    }


    public void setIfcKakuninsakikbn(String pIfcKakuninsakikbn) {
        ifcKakuninsakikbn = pIfcKakuninsakikbn;
    }


    @Column(order = 7, label = "確認区分")
    private String ifcKakuninkbn;


    public String getIfcKakuninkbn() {
        return ifcKakuninkbn;
    }


    public void setIfcKakuninkbn(String pIfcKakuninkbn) {
        ifcKakuninkbn = pIfcKakuninkbn;
    }


    @Column(order = 8, label = "給付区分")
    private String ifcKyuuhukbn;


    public String getIfcKyuuhukbn() {
        return ifcKyuuhukbn;
    }


    public void setIfcKyuuhukbn(String pIfcKyuuhukbn) {
        ifcKyuuhukbn = pIfcKyuuhukbn;
    }


    @Column(order = 9, label = "本人妻子区分")
    private String ifcHonninsaisikbn;


    public String getIfcHonninsaisikbn() {
        return ifcHonninsaisikbn;
    }


    public void setIfcHonninsaisikbn(String pIfcHonninsaisikbn) {
        ifcHonninsaisikbn = pIfcHonninsaisikbn;
    }


    @Column(order = 10, label = "対象者区分")
    private String ifcTaisyousyakbn;


    public String getIfcTaisyousyakbn() {
        return ifcTaisyousyakbn;
    }


    public void setIfcTaisyousyakbn(String pIfcTaisyousyakbn) {
        ifcTaisyousyakbn = pIfcTaisyousyakbn;
    }


    @Column(order = 11, label = "請求区分")
    private String ifcSeikyuukbn;


    public String getIfcSeikyuukbn() {
        return ifcSeikyuukbn;
    }


    public void setIfcSeikyuukbn(String pIfcSeikyuukbn) {
        ifcSeikyuukbn = pIfcSeikyuukbn;
    }


    @Column(order = 12, label = "傷病者名カナ")
    private String ifcSyoubyousyakn;


    public String getIfcSyoubyousyakn() {
        return ifcSyoubyousyakn;
    }


    public void setIfcSyoubyousyakn(String pIfcSyoubyousyakn) {
        ifcSyoubyousyakn = pIfcSyoubyousyakn;
    }


    @Column(order = 13, label = "傷病者名漢字")
    private String ifcSyoubyousyakj;


    public String getIfcSyoubyousyakj() {
        return ifcSyoubyousyakj;
    }


    public void setIfcSyoubyousyakj(String pIfcSyoubyousyakj) {
        ifcSyoubyousyakj = pIfcSyoubyousyakj;
    }


    @Column(order = 14, label = "傷病者生年月日")
    private BizDate ifcSyoubyousyaseiymd;


    public BizDate getIfcSyoubyousyaseiymd() {
        return ifcSyoubyousyaseiymd;
    }


    public void setIfcSyoubyousyaseiymd(BizDate pIfcSyoubyousyaseiymd) {
        ifcSyoubyousyaseiymd = pIfcSyoubyousyaseiymd;
    }


    @Column(order = 15, label = "被保険者区分")
    private String ifcHhknkbn;


    public String getIfcHhknkbn() {
        return ifcHhknkbn;
    }


    public void setIfcHhknkbn(String pIfcHhknkbn) {
        ifcHhknkbn = pIfcHhknkbn;
    }


    @Column(order = 16, label = "被保険者名カナ")
    private String ifcHhknmeikn;


    public String getIfcHhknmeikn() {
        return ifcHhknmeikn;
    }


    @DataConvert("toSingleByte")
    public void setIfcHhknmeikn(String pIfcHhknmeikn) {
        ifcHhknmeikn = pIfcHhknmeikn;
    }


    @Column(order = 17, label = "被保険者名漢字")
    private String ifcHhknmeikj;


    public String getIfcHhknmeikj() {
        return ifcHhknmeikj;
    }


    public void setIfcHhknmeikj(String pIfcHhknmeikj) {
        ifcHhknmeikj = pIfcHhknmeikj;
    }


    @Column(order = 18, label = "被保険者生年月日")
    private BizDate ifcHihokensyaseiymd;


    public BizDate getIfcHihokensyaseiymd() {
        return ifcHihokensyaseiymd;
    }


    public void setIfcHihokensyaseiymd(BizDate pIfcHihokensyaseiymd) {
        ifcHihokensyaseiymd = pIfcHihokensyaseiymd;
    }


    @Column(order = 19, label = "第二被保険者名カナ")
    private String ifcDai2hhknmeikn;


    public String getIfcDai2hhknmeikn() {
        return ifcDai2hhknmeikn;
    }


    public void setIfcDai2hhknmeikn(String pIfcDai2hhknmeikn) {
        ifcDai2hhknmeikn = pIfcDai2hhknmeikn;
    }


    @Column(order = 20, label = "第二被保険者名漢字")
    private String ifcDai2hhknmeikj;


    public String getIfcDai2hhknmeikj() {
        return ifcDai2hhknmeikj;
    }


    public void setIfcDai2hhknmeikj(String pIfcDai2hhknmeikj) {
        ifcDai2hhknmeikj = pIfcDai2hhknmeikj;
    }


    @Column(order = 21, label = "第二被保険者生年月日")
    private BizDate ifcDai2hhknseiymd;


    public BizDate getIfcDai2hhknseiymd() {
        return ifcDai2hhknseiymd;
    }


    public void setIfcDai2hhknseiymd(BizDate pIfcDai2hhknseiymd) {
        ifcDai2hhknseiymd = pIfcDai2hhknseiymd;
    }


    @Column(order = 22, label = "基準日")
    private BizDate ifcKijyunymd;


    public BizDate getIfcKijyunymd() {
        return ifcKijyunymd;
    }


    public void setIfcKijyunymd(BizDate pIfcKijyunymd) {
        ifcKijyunymd = pIfcKijyunymd;
    }


    @Column(order = 23, label = "書類受付日")
    private BizDate ifcSyoruiukeymd;


    public BizDate getIfcSyoruiukeymd() {
        return ifcSyoruiukeymd;
    }


    public void setIfcSyoruiukeymd(BizDate pIfcSyoruiukeymd) {
        ifcSyoruiukeymd = pIfcSyoruiukeymd;
    }


    @Column(order = 24, label = "依頼元コメント")
    private String ifcIraimotocomment;


    public String getIfcIraimotocomment() {
        return ifcIraimotocomment;
    }


    public void setIfcIraimotocomment(String pIfcIraimotocomment) {
        ifcIraimotocomment = pIfcIraimotocomment;
    }


    @Column(order = 25, label = "不備同時確認有無")
    private String ifcHubidojikakuninumu;


    public String getIfcHubidojikakuninumu() {
        return ifcHubidojikakuninumu;
    }


    public void setIfcHubidojikakuninumu(String pIfcHubidojikakuninumu) {
        ifcHubidojikakuninumu = pIfcHubidojikakuninumu;
    }


    @Column(order = 26, label = "契約者名カナ")
    private String ifcKyksyameikn;


    public String getIfcKyksyameikn() {
        return ifcKyksyameikn;
    }


    @DataConvert("toSingleByte")
    public void setIfcKyksyameikn(String pIfcKyksyameikn) {
        ifcKyksyameikn = pIfcKyksyameikn;
    }


    @Column(order = 27, label = "契約者名漢字")
    private String ifcKyksyameikj;


    public String getIfcKyksyameikj() {
        return ifcKyksyameikj;
    }


    public void setIfcKyksyameikj(String pIfcKyksyameikj) {
        ifcKyksyameikj = pIfcKyksyameikj;
    }


    @Column(order = 28, label = "契約者生年月日")
    private BizDate ifcKeiyakuseiymd;


    public BizDate getIfcKeiyakuseiymd() {
        return ifcKeiyakuseiymd;
    }


    public void setIfcKeiyakuseiymd(BizDate pIfcKeiyakuseiymd) {
        ifcKeiyakuseiymd = pIfcKeiyakuseiymd;
    }


    @Column(order = 29, label = "契約者住所")
    private String ifcKykadr;


    public String getIfcKykadr() {
        return ifcKykadr;
    }


    public void setIfcKykadr(String pIfcKykadr) {
        ifcKykadr = pIfcKykadr;
    }


    @Column(order = 30, label = "指定代理人名カナ")
    private String ifcSiteidairimeikn;


    public String getIfcSiteidairimeikn() {
        return ifcSiteidairimeikn;
    }


    @DataConvert("toSingleByte")
    public void setIfcSiteidairimeikn(String pIfcSiteidairimeikn) {
        ifcSiteidairimeikn = pIfcSiteidairimeikn;
    }


    @Column(order = 31, label = "指定代理人名漢字")
    private String ifcSiteidairimeikj;


    public String getIfcSiteidairimeikj() {
        return ifcSiteidairimeikj;
    }


    public void setIfcSiteidairimeikj(String pIfcSiteidairimeikj) {
        ifcSiteidairimeikj = pIfcSiteidairimeikj;
    }


    @Column(order = 32, label = "送付先住所")
    private String ifcShadr;


    public String getIfcShadr() {
        return ifcShadr;
    }


    public void setIfcShadr(String pIfcShadr) {
        ifcShadr = pIfcShadr;
    }


    @Column(order = 33, label = "郵便番号")
    private String ifcYno;


    public String getIfcYno() {
        return ifcYno;
    }


    public void setIfcYno(String pIfcYno) {
        ifcYno = pIfcYno;
    }


    @Column(order = 34, label = "基本地区コード")
    private String ifcKihontikucd;


    public String getIfcKihontikucd() {
        return ifcKihontikucd;
    }


    public void setIfcKihontikucd(String pIfcKihontikucd) {
        ifcKihontikucd = pIfcKihontikucd;
    }


    @Column(order = 35, label = "上位住所")
    private String ifcJyouiadr;


    public String getIfcJyouiadr() {
        return ifcJyouiadr;
    }


    public void setIfcJyouiadr(String pIfcJyouiadr) {
        ifcJyouiadr = pIfcJyouiadr;
    }


    @Column(order = 36, label = "下位住所")
    private String ifcKaiadr;


    public String getIfcKaiadr() {
        return ifcKaiadr;
    }


    public void setIfcKaiadr(String pIfcKaiadr) {
        ifcKaiadr = pIfcKaiadr;
    }


    @Column(order = 37, label = "折衝依頼先支社コード")
    private String ifcSsyiriskissycd;


    public String getIfcSsyiriskissycd() {
        return ifcSsyiriskissycd;
    }


    public void setIfcSsyiriskissycd(String pIfcSsyiriskissycd) {
        ifcSsyiriskissycd = pIfcSsyiriskissycd;
    }


    @Column(order = 38, label = "窓販種別区分")
    private String ifcMdhansybetukbn;


    public String getIfcMdhansybetukbn() {
        return ifcMdhansybetukbn;
    }


    public void setIfcMdhansybetukbn(String pIfcMdhansybetukbn) {
        ifcMdhansybetukbn = pIfcMdhansybetukbn;
    }


    @Column(order = 39, label = "法人特則表示")
    private String ifcHjntkskhyj;


    public String getIfcHjntkskhyj() {
        return ifcHjntkskhyj;
    }


    public void setIfcHjntkskhyj(String pIfcHjntkskhyj) {
        ifcHjntkskhyj = pIfcHjntkskhyj;
    }


    @Column(order = 40, label = "教育保険表示")
    private String ifcKykhknhyj;


    public String getIfcKykhknhyj() {
        return ifcKykhknhyj;
    }


    public void setIfcKykhknhyj(String pIfcKykhknhyj) {
        ifcKykhknhyj = pIfcKykhknhyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
