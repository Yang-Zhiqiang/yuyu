package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）ＮＩＴペーパーレス不備ＣＳＶファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkNitPplessHubiCsvFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkNitPplessHubiCsvFile() {
    }


    @Column(order = 1, label = "（ＩＦｃ）案件ＩＤ")
    private String ifcAnkenid;


    public String getIfcAnkenid() {
        return ifcAnkenid;
    }


    public void setIfcAnkenid(String pIfcAnkenid) {
        ifcAnkenid = pIfcAnkenid;
    }


    @Column(order = 2, label = "（ＩＦｃ）案件枝番")
    private String ifcAnkenedano;


    public String getIfcAnkenedano() {
        return ifcAnkenedano;
    }


    public void setIfcAnkenedano(String pIfcAnkenedano) {
        ifcAnkenedano = pIfcAnkenedano;
    }


    @Column(order = 3, label = "（ＩＦｃ）申込番号")
    private String ifcMosno;


    public String getIfcMosno() {
        return ifcMosno;
    }


    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }


    @Column(order = 4, label = "（ＩＦｃ）金融機関コード")
    private String ifcKinyuucd;


    public String getIfcKinyuucd() {
        return ifcKinyuucd;
    }


    public void setIfcKinyuucd(String pIfcKinyuucd) {
        ifcKinyuucd = pIfcKinyuucd;
    }


    @Column(order = 5, label = "（ＩＦｃ）保険会社コード")
    private String ifcHknkaisyacd;


    public String getIfcHknkaisyacd() {
        return ifcHknkaisyacd;
    }


    public void setIfcHknkaisyacd(String pIfcHknkaisyacd) {
        ifcHknkaisyacd = pIfcHknkaisyacd;
    }


    @Column(order = 6, label = "（ＩＦｃ）商品コード")
    private String ifcSyouhncd;


    public String getIfcSyouhncd() {
        return ifcSyouhncd;
    }


    public void setIfcSyouhncd(String pIfcSyouhncd) {
        ifcSyouhncd = pIfcSyouhncd;
    }


    @Column(order = 7, label = "（ＩＦｃ）支店コード")
    private String ifcSitencd;


    public String getIfcSitencd() {
        return ifcSitencd;
    }


    public void setIfcSitencd(String pIfcSitencd) {
        ifcSitencd = pIfcSitencd;
    }


    @Column(order = 8, label = "（ＩＦｃ）ＣＩＦコード")
    private String ifcCifcd;


    public String getIfcCifcd() {
        return ifcCifcd;
    }


    public void setIfcCifcd(String pIfcCifcd) {
        ifcCifcd = pIfcCifcd;
    }


    @Column(order = 9, label = "（ＩＦｃ）取扱者コード")
    private String ifcTratkisyacd;


    public String getIfcTratkisyacd() {
        return ifcTratkisyacd;
    }


    public void setIfcTratkisyacd(String pIfcTratkisyacd) {
        ifcTratkisyacd = pIfcTratkisyacd;
    }


    @Column(order = 10, label = "（ＩＦｃ）予備１（新契約）")
    private String ifcYobi1sinkeiyaku;


    public String getIfcYobi1sinkeiyaku() {
        return ifcYobi1sinkeiyaku;
    }


    public void setIfcYobi1sinkeiyaku(String pIfcYobi1sinkeiyaku) {
        ifcYobi1sinkeiyaku = pIfcYobi1sinkeiyaku;
    }


    @Column(order = 11, label = "（ＩＦｃ）予備２（新契約）")
    private String ifcYobi2sinkeiyaku;


    public String getIfcYobi2sinkeiyaku() {
        return ifcYobi2sinkeiyaku;
    }


    public void setIfcYobi2sinkeiyaku(String pIfcYobi2sinkeiyaku) {
        ifcYobi2sinkeiyaku = pIfcYobi2sinkeiyaku;
    }


    @Column(order = 12, label = "（ＩＦｃ）レイアウト改訂番号")
    private String ifcLayoutkaiteino;


    public String getIfcLayoutkaiteino() {
        return ifcLayoutkaiteino;
    }


    public void setIfcLayoutkaiteino(String pIfcLayoutkaiteino) {
        ifcLayoutkaiteino = pIfcLayoutkaiteino;
    }


    @Column(order = 13, label = "（ＩＦｃ）削除フラグ")
    private String ifcSakujyoflg;


    public String getIfcSakujyoflg() {
        return ifcSakujyoflg;
    }


    public void setIfcSakujyoflg(String pIfcSakujyoflg) {
        ifcSakujyoflg = pIfcSakujyoflg;
    }


    @Column(order = 14, label = "（ＩＦｃ）保険会社＿部署")
    private String ifcHknkaisyabusyo;


    public String getIfcHknkaisyabusyo() {
        return ifcHknkaisyabusyo;
    }


    public void setIfcHknkaisyabusyo(String pIfcHknkaisyabusyo) {
        ifcHknkaisyabusyo = pIfcHknkaisyabusyo;
    }


    @Column(order = 15, label = "（ＩＦｃ）保険会社＿連絡先電話番号＿市外局番")
    private String ifcHknkaisyatelno1;


    public String getIfcHknkaisyatelno1() {
        return ifcHknkaisyatelno1;
    }


    public void setIfcHknkaisyatelno1(String pIfcHknkaisyatelno1) {
        ifcHknkaisyatelno1 = pIfcHknkaisyatelno1;
    }


    @Column(order = 16, label = "（ＩＦｃ）保険会社＿連絡先電話番号＿市内局番")
    private String ifcHknkaisyatelno2;


    public String getIfcHknkaisyatelno2() {
        return ifcHknkaisyatelno2;
    }


    public void setIfcHknkaisyatelno2(String pIfcHknkaisyatelno2) {
        ifcHknkaisyatelno2 = pIfcHknkaisyatelno2;
    }


    @Column(order = 17, label = "（ＩＦｃ）保険会社＿連絡先電話番号＿加入者番号")
    private String ifcHknkaisyatelno3;


    public String getIfcHknkaisyatelno3() {
        return ifcHknkaisyatelno3;
    }


    public void setIfcHknkaisyatelno3(String pIfcHknkaisyatelno3) {
        ifcHknkaisyatelno3 = pIfcHknkaisyatelno3;
    }


    @Column(order = 18, label = "（ＩＦｃ）担当者名")
    private String ifcTntnm;


    public String getIfcTntnm() {
        return ifcTntnm;
    }


    public void setIfcTntnm(String pIfcTntnm) {
        ifcTntnm = pIfcTntnm;
    }


    @Column(order = 19, label = "（ＩＦｃ）不備状況１")
    private String ifcHubijyoukyou1;


    public String getIfcHubijyoukyou1() {
        return ifcHubijyoukyou1;
    }


    public void setIfcHubijyoukyou1(String pIfcHubijyoukyou1) {
        ifcHubijyoukyou1 = pIfcHubijyoukyou1;
    }


    @Column(order = 20, label = "（ＩＦｃ）不備状況２")
    private String ifcHubijyoukyou2;


    public String getIfcHubijyoukyou2() {
        return ifcHubijyoukyou2;
    }


    public void setIfcHubijyoukyou2(String pIfcHubijyoukyou2) {
        ifcHubijyoukyou2 = pIfcHubijyoukyou2;
    }


    @Column(order = 21, label = "（ＩＦｃ）不備状況３")
    private String ifcHubijyoukyou3;


    public String getIfcHubijyoukyou3() {
        return ifcHubijyoukyou3;
    }


    public void setIfcHubijyoukyou3(String pIfcHubijyoukyou3) {
        ifcHubijyoukyou3 = pIfcHubijyoukyou3;
    }


    @Column(order = 22, label = "（ＩＦｃ）不備状況４")
    private String ifcHubijyoukyou4;


    public String getIfcHubijyoukyou4() {
        return ifcHubijyoukyou4;
    }


    public void setIfcHubijyoukyou4(String pIfcHubijyoukyou4) {
        ifcHubijyoukyou4 = pIfcHubijyoukyou4;
    }


    @Column(order = 23, label = "（ＩＦｃ）不備状況５")
    private String ifcHubijyoukyou5;


    public String getIfcHubijyoukyou5() {
        return ifcHubijyoukyou5;
    }


    public void setIfcHubijyoukyou5(String pIfcHubijyoukyou5) {
        ifcHubijyoukyou5 = pIfcHubijyoukyou5;
    }


    @Column(order = 24, label = "（ＩＦｃ）不備回答１")
    private String ifcHubikaitou1;


    public String getIfcHubikaitou1() {
        return ifcHubikaitou1;
    }


    public void setIfcHubikaitou1(String pIfcHubikaitou1) {
        ifcHubikaitou1 = pIfcHubikaitou1;
    }


    @Column(order = 25, label = "（ＩＦｃ）不備回答２")
    private String ifcHubikaitou2;


    public String getIfcHubikaitou2() {
        return ifcHubikaitou2;
    }


    public void setIfcHubikaitou2(String pIfcHubikaitou2) {
        ifcHubikaitou2 = pIfcHubikaitou2;
    }


    @Column(order = 26, label = "（ＩＦｃ）不備回答３")
    private String ifcHubikaitou3;


    public String getIfcHubikaitou3() {
        return ifcHubikaitou3;
    }


    public void setIfcHubikaitou3(String pIfcHubikaitou3) {
        ifcHubikaitou3 = pIfcHubikaitou3;
    }


    @Column(order = 27, label = "（ＩＦｃ）不備回答４")
    private String ifcHubikaitou4;


    public String getIfcHubikaitou4() {
        return ifcHubikaitou4;
    }


    public void setIfcHubikaitou4(String pIfcHubikaitou4) {
        ifcHubikaitou4 = pIfcHubikaitou4;
    }


    @Column(order = 28, label = "（ＩＦｃ）不備回答５")
    private String ifcHubikaitou5;


    public String getIfcHubikaitou5() {
        return ifcHubikaitou5;
    }


    public void setIfcHubikaitou5(String pIfcHubikaitou5) {
        ifcHubikaitou5 = pIfcHubikaitou5;
    }


    @Column(order = 29, label = "（ＩＦｃ）添付書類＿訂正補足")
    private String ifcTpsyoruitshsk;


    public String getIfcTpsyoruitshsk() {
        return ifcTpsyoruitshsk;
    }


    public void setIfcTpsyoruitshsk(String pIfcTpsyoruitshsk) {
        ifcTpsyoruitshsk = pIfcTpsyoruitshsk;
    }


    @Column(order = 30, label = "（ＩＦｃ）添付書類＿増減確認")
    private String ifcTpsyoruizougenkak;


    public String getIfcTpsyoruizougenkak() {
        return ifcTpsyoruizougenkak;
    }


    public void setIfcTpsyoruizougenkak(String pIfcTpsyoruizougenkak) {
        ifcTpsyoruizougenkak = pIfcTpsyoruizougenkak;
    }


    @Column(order = 31, label = "（ＩＦｃ）添付書類＿特別条件")
    private String ifcTpsyoruitkbtjkn;


    public String getIfcTpsyoruitkbtjkn() {
        return ifcTpsyoruitkbtjkn;
    }


    public void setIfcTpsyoruitkbtjkn(String pIfcTpsyoruitkbtjkn) {
        ifcTpsyoruitkbtjkn = pIfcTpsyoruitkbtjkn;
    }


    @Column(order = 32, label = "（ＩＦｃ）添付書類＿その他")
    private String ifcTpsyoruietc;


    public String getIfcTpsyoruietc() {
        return ifcTpsyoruietc;
    }


    public void setIfcTpsyoruietc(String pIfcTpsyoruietc) {
        ifcTpsyoruietc = pIfcTpsyoruietc;
    }


    @Column(order = 33, label = "（ＩＦｃ）添付書類＿詳細")
    private String ifcTpsyoruisyousai;


    public String getIfcTpsyoruisyousai() {
        return ifcTpsyoruisyousai;
    }


    public void setIfcTpsyoruisyousai(String pIfcTpsyoruisyousai) {
        ifcTpsyoruisyousai = pIfcTpsyoruisyousai;
    }


    @Column(order = 34, label = "（ＩＦｃ）不備回答日")
    private String ifcHubikaitouymd;


    public String getIfcHubikaitouymd() {
        return ifcHubikaitouymd;
    }


    public void setIfcHubikaitouymd(String pIfcHubikaitouymd) {
        ifcHubikaitouymd = pIfcHubikaitouymd;
    }


    @Column(order = 35, label = "（ＩＦｃ）取扱者名")
    private String ifcTratkisyanm;


    public String getIfcTratkisyanm() {
        return ifcTratkisyanm;
    }


    public void setIfcTratkisyanm(String pIfcTratkisyanm) {
        ifcTratkisyanm = pIfcTratkisyanm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
