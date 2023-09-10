package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * （支払）請求情報レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSeikyuuInfoLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiSeikyuuInfoLayoutFile() {
    }


    @Column(order = 1, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 2, label = "請求番号")
    @NotNull
    private String ifcSkno;


    public String getIfcSkno() {
        return ifcSkno;
    }


    public void setIfcSkno(String pIfcSkno) {
        ifcSkno = pIfcSkno;
    }


    @Column(order = 3, label = "請求種別")
    private String ifcSeikyuusyubetu;


    public String getIfcSeikyuusyubetu() {
        return ifcSeikyuusyubetu;
    }


    public void setIfcSeikyuusyubetu(String pIfcSeikyuusyubetu) {
        ifcSeikyuusyubetu = pIfcSeikyuusyubetu;
    }


    @Column(order = 4, label = "再査定区分")
    private C_SaisateiKbn ifcSaisateikbn;


    public C_SaisateiKbn getIfcSaisateikbn() {
        return ifcSaisateikbn;
    }


    public void setIfcSaisateikbn(C_SaisateiKbn pIfcSaisateikbn) {
        ifcSaisateikbn = pIfcSaisateikbn;
    }


    @Column(order = 5, label = "死亡仮受付日")
    private BizDate ifcSiboukariymd;


    public BizDate getIfcSiboukariymd() {
        return ifcSiboukariymd;
    }


    public void setIfcSiboukariymd(BizDate pIfcSiboukariymd) {
        ifcSiboukariymd = pIfcSiboukariymd;
    }


    @Column(order = 6, label = "死亡日")
    private BizDate ifcSibouymd;


    public BizDate getIfcSibouymd() {
        return ifcSibouymd;
    }


    public void setIfcSibouymd(BizDate pIfcSibouymd) {
        ifcSibouymd = pIfcSibouymd;
    }


    @Column(order = 7, label = "原因区分")
    private String ifcHnykgeninkbn;


    public String getIfcHnykgeninkbn() {
        return ifcHnykgeninkbn;
    }


    public void setIfcHnykgeninkbn(String pIfcHnykgeninkbn) {
        ifcHnykgeninkbn = pIfcHnykgeninkbn;
    }


    @Column(order = 8, label = "死因区分")
    private String ifcHnyksiinkbn;


    public String getIfcHnyksiinkbn() {
        return ifcHnyksiinkbn;
    }


    public void setIfcHnyksiinkbn(String pIfcHnyksiinkbn) {
        ifcHnyksiinkbn = pIfcHnyksiinkbn;
    }


    @Column(order = 9, label = "契約日")
    private BizDate ifcKykymd;


    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }


    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }


    @Column(order = 10, label = "契約者名（漢字）")
    private String ifcKyknmkj;


    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }


    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }


    @Column(order = 11, label = "契約者名（カナ）")
    private String ifcKyknmkn;


    public String getIfcKyknmkn() {
        return ifcKyknmkn;
    }


    public void setIfcKyknmkn(String pIfcKyknmkn) {
        ifcKyknmkn = pIfcKyknmkn;
    }


    @Column(order = 12, label = "被保険者名（漢字）")
    private String ifcHhknnmkj;


    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }


    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }


    @Column(order = 13, label = "被保険者名（カナ）")
    private String ifcHhknnmkn;


    public String getIfcHhknnmkn() {
        return ifcHhknnmkn;
    }


    public void setIfcHhknnmkn(String pIfcHhknnmkn) {
        ifcHhknnmkn = pIfcHhknnmkn;
    }


    @Column(order = 14, label = "被保険者生年月日")
    private BizDate ifcHhknseiymd;


    public BizDate getIfcHhknseiymd() {
        return ifcHhknseiymd;
    }


    public void setIfcHhknseiymd(BizDate pIfcHhknseiymd) {
        ifcHhknseiymd = pIfcHhknseiymd;
    }


    @Column(order = 15, label = "被保険者性別")
    private C_Hhknsei ifcHhknsei;


    public C_Hhknsei getIfcHhknsei() {
        return ifcHhknsei;
    }


    public void setIfcHhknsei(C_Hhknsei pIfcHhknsei) {
        ifcHhknsei = pIfcHhknsei;
    }


    @Column(order = 16, label = "死亡受取人人数")
    private Integer ifcSbuktnin;


    public Integer getIfcSbuktnin() {
        return ifcSbuktnin;
    }


    public void setIfcSbuktnin(Integer pIfcSbuktnin) {
        ifcSbuktnin = pIfcSbuktnin;
    }


    @Column(order = 17, label = "受取人区分")
    private String ifcHnykuktkbn;


    public String getIfcHnykuktkbn() {
        return ifcHnykuktkbn;
    }


    public void setIfcHnykuktkbn(String pIfcHnykuktkbn) {
        ifcHnykuktkbn = pIfcHnykuktkbn;
    }


    @Column(order = 18, label = "受取人名（漢字）")
    private String ifcUktnmkj;


    public String getIfcUktnmkj() {
        return ifcUktnmkj;
    }


    public void setIfcUktnmkj(String pIfcUktnmkj) {
        ifcUktnmkj = pIfcUktnmkj;
    }


    @Column(order = 19, label = "受取人生年月日")
    private BizDate ifcUktseiymd;


    public BizDate getIfcUktseiymd() {
        return ifcUktseiymd;
    }


    public void setIfcUktseiymd(BizDate pIfcUktseiymd) {
        ifcUktseiymd = pIfcUktseiymd;
    }


    @Column(order = 20, label = "分割割合")
    private BizNumber ifcUktbnwari;


    public BizNumber getIfcUktbnwari() {
        return ifcUktbnwari;
    }


    public void setIfcUktbnwari(BizNumber pIfcUktbnwari) {
        ifcUktbnwari = pIfcUktbnwari;
    }


    @Column(order = 21, label = "商品コード")
    private String ifcSyouhncd;


    public String getIfcSyouhncd() {
        return ifcSyouhncd;
    }


    public void setIfcSyouhncd(String pIfcSyouhncd) {
        ifcSyouhncd = pIfcSyouhncd;
    }


    @Column(order = 22, label = "最低保証有無")
    private C_UmuKbn ifcSaiteihosyouumu;


    public C_UmuKbn getIfcSaiteihosyouumu() {
        return ifcSaiteihosyouumu;
    }


    public void setIfcSaiteihosyouumu(C_UmuKbn pIfcSaiteihosyouumu) {
        ifcSaiteihosyouumu = pIfcSaiteihosyouumu;
    }


    @Column(order = 23, label = "手続注意内容１")
    private String ifcTtdktyuuinaiyou1;


    public String getIfcTtdktyuuinaiyou1() {
        return ifcTtdktyuuinaiyou1;
    }


    public void setIfcTtdktyuuinaiyou1(String pIfcTtdktyuuinaiyou1) {
        ifcTtdktyuuinaiyou1 = pIfcTtdktyuuinaiyou1;
    }


    @Column(order = 24, label = "手続注意内容２")
    private String ifcTtdktyuuinaiyou2;


    public String getIfcTtdktyuuinaiyou2() {
        return ifcTtdktyuuinaiyou2;
    }


    public void setIfcTtdktyuuinaiyou2(String pIfcTtdktyuuinaiyou2) {
        ifcTtdktyuuinaiyou2 = pIfcTtdktyuuinaiyou2;
    }


    @Column(order = 25, label = "手続注意内容３")
    private String ifcTtdktyuuinaiyou3;


    public String getIfcTtdktyuuinaiyou3() {
        return ifcTtdktyuuinaiyou3;
    }


    public void setIfcTtdktyuuinaiyou3(String pIfcTtdktyuuinaiyou3) {
        ifcTtdktyuuinaiyou3 = pIfcTtdktyuuinaiyou3;
    }


    @Column(order = 26, label = "手続注意区分１")
    private String ifcHnykttdktyuuikbn1;


    public String getIfcHnykttdktyuuikbn1() {
        return ifcHnykttdktyuuikbn1;
    }


    public void setIfcHnykttdktyuuikbn1(String pIfcHnykttdktyuuikbn1) {
        ifcHnykttdktyuuikbn1 = pIfcHnykttdktyuuikbn1;
    }


    @Column(order = 27, label = "手続注意区分補足内容１")
    private String ifcTtdktyuuikbnhsknaiyou1;


    public String getIfcTtdktyuuikbnhsknaiyou1() {
        return ifcTtdktyuuikbnhsknaiyou1;
    }


    public void setIfcTtdktyuuikbnhsknaiyou1(String pIfcTtdktyuuikbnhsknaiyou1) {
        ifcTtdktyuuikbnhsknaiyou1 = pIfcTtdktyuuikbnhsknaiyou1;
    }


    @Column(order = 28, label = "手続注意区分設定日１")
    private BizDate ifcTtdktyuuikbnsetymd1;


    public BizDate getIfcTtdktyuuikbnsetymd1() {
        return ifcTtdktyuuikbnsetymd1;
    }


    public void setIfcTtdktyuuikbnsetymd1(BizDate pIfcTtdktyuuikbnsetymd1) {
        ifcTtdktyuuikbnsetymd1 = pIfcTtdktyuuikbnsetymd1;
    }


    @Column(order = 29, label = "手続注意区分２")
    private String ifcHnykttdktyuuikbn2;


    public String getIfcHnykttdktyuuikbn2() {
        return ifcHnykttdktyuuikbn2;
    }


    public void setIfcHnykttdktyuuikbn2(String pIfcHnykttdktyuuikbn2) {
        ifcHnykttdktyuuikbn2 = pIfcHnykttdktyuuikbn2;
    }


    @Column(order = 30, label = "手続注意区分補足内容２")
    private String ifcTtdktyuuikbnhsknaiyou2;


    public String getIfcTtdktyuuikbnhsknaiyou2() {
        return ifcTtdktyuuikbnhsknaiyou2;
    }


    public void setIfcTtdktyuuikbnhsknaiyou2(String pIfcTtdktyuuikbnhsknaiyou2) {
        ifcTtdktyuuikbnhsknaiyou2 = pIfcTtdktyuuikbnhsknaiyou2;
    }


    @Column(order = 31, label = "手続注意区分設定日２")
    private BizDate ifcTtdktyuuikbnsetymd2;


    public BizDate getIfcTtdktyuuikbnsetymd2() {
        return ifcTtdktyuuikbnsetymd2;
    }


    public void setIfcTtdktyuuikbnsetymd2(BizDate pIfcTtdktyuuikbnsetymd2) {
        ifcTtdktyuuikbnsetymd2 = pIfcTtdktyuuikbnsetymd2;
    }


    @Column(order = 32, label = "手続注意区分３")
    private String ifcHnykttdktyuuikbn3;


    public String getIfcHnykttdktyuuikbn3() {
        return ifcHnykttdktyuuikbn3;
    }


    public void setIfcHnykttdktyuuikbn3(String pIfcHnykttdktyuuikbn3) {
        ifcHnykttdktyuuikbn3 = pIfcHnykttdktyuuikbn3;
    }


    @Column(order = 33, label = "手続注意区分補足内容３")
    private String ifcTtdktyuuikbnhsknaiyou3;


    public String getIfcTtdktyuuikbnhsknaiyou3() {
        return ifcTtdktyuuikbnhsknaiyou3;
    }


    public void setIfcTtdktyuuikbnhsknaiyou3(String pIfcTtdktyuuikbnhsknaiyou3) {
        ifcTtdktyuuikbnhsknaiyou3 = pIfcTtdktyuuikbnhsknaiyou3;
    }


    @Column(order = 34, label = "手続注意区分設定日３")
    private BizDate ifcTtdktyuuikbnsetymd3;


    public BizDate getIfcTtdktyuuikbnsetymd3() {
        return ifcTtdktyuuikbnsetymd3;
    }


    public void setIfcTtdktyuuikbnsetymd3(BizDate pIfcTtdktyuuikbnsetymd3) {
        ifcTtdktyuuikbnsetymd3 = pIfcTtdktyuuikbnsetymd3;
    }


    @Column(order = 35, label = "手続注意区分４")
    private String ifcHnykttdktyuuikbn4;


    public String getIfcHnykttdktyuuikbn4() {
        return ifcHnykttdktyuuikbn4;
    }


    public void setIfcHnykttdktyuuikbn4(String pIfcHnykttdktyuuikbn4) {
        ifcHnykttdktyuuikbn4 = pIfcHnykttdktyuuikbn4;
    }


    @Column(order = 36, label = "手続注意区分補足内容４")
    private String ifcTtdktyuuikbnhsknaiyou4;


    public String getIfcTtdktyuuikbnhsknaiyou4() {
        return ifcTtdktyuuikbnhsknaiyou4;
    }


    public void setIfcTtdktyuuikbnhsknaiyou4(String pIfcTtdktyuuikbnhsknaiyou4) {
        ifcTtdktyuuikbnhsknaiyou4 = pIfcTtdktyuuikbnhsknaiyou4;
    }


    @Column(order = 37, label = "手続注意区分設定日４")
    private BizDate ifcTtdktyuuikbnsetymd4;


    public BizDate getIfcTtdktyuuikbnsetymd4() {
        return ifcTtdktyuuikbnsetymd4;
    }


    public void setIfcTtdktyuuikbnsetymd4(BizDate pIfcTtdktyuuikbnsetymd4) {
        ifcTtdktyuuikbnsetymd4 = pIfcTtdktyuuikbnsetymd4;
    }


    @Column(order = 38, label = "手続注意区分５")
    private String ifcHnykttdktyuuikbn5;


    public String getIfcHnykttdktyuuikbn5() {
        return ifcHnykttdktyuuikbn5;
    }


    public void setIfcHnykttdktyuuikbn5(String pIfcHnykttdktyuuikbn5) {
        ifcHnykttdktyuuikbn5 = pIfcHnykttdktyuuikbn5;
    }


    @Column(order = 39, label = "手続注意区分補足内容５")
    private String ifcTtdktyuuikbnhsknaiyou5;


    public String getIfcTtdktyuuikbnhsknaiyou5() {
        return ifcTtdktyuuikbnhsknaiyou5;
    }


    public void setIfcTtdktyuuikbnhsknaiyou5(String pIfcTtdktyuuikbnhsknaiyou5) {
        ifcTtdktyuuikbnhsknaiyou5 = pIfcTtdktyuuikbnhsknaiyou5;
    }


    @Column(order = 40, label = "手続注意区分設定日５")
    private BizDate ifcTtdktyuuikbnsetymd5;


    public BizDate getIfcTtdktyuuikbnsetymd5() {
        return ifcTtdktyuuikbnsetymd5;
    }


    public void setIfcTtdktyuuikbnsetymd5(BizDate pIfcTtdktyuuikbnsetymd5) {
        ifcTtdktyuuikbnsetymd5 = pIfcTtdktyuuikbnsetymd5;
    }


    @Column(order = 41, label = "請求者区分")
    private String ifcHnykseikyuusyakbn;


    public String getIfcHnykseikyuusyakbn() {
        return ifcHnykseikyuusyakbn;
    }


    public void setIfcHnykseikyuusyakbn(String pIfcHnykseikyuusyakbn) {
        ifcHnykseikyuusyakbn = pIfcHnykseikyuusyakbn;
    }


    @Column(order = 42, label = "請求者名（カナ）")
    private String ifcSeikyuusyanmkn;


    public String getIfcSeikyuusyanmkn() {
        return ifcSeikyuusyanmkn;
    }


    public void setIfcSeikyuusyanmkn(String pIfcSeikyuusyanmkn) {
        ifcSeikyuusyanmkn = pIfcSeikyuusyanmkn;
    }


    @Column(order = 43, label = "請求者名（漢字）")
    private String ifcSeikyuusyanmkj;


    public String getIfcSeikyuusyanmkj() {
        return ifcSeikyuusyanmkj;
    }


    public void setIfcSeikyuusyanmkj(String pIfcSeikyuusyanmkj) {
        ifcSeikyuusyanmkj = pIfcSeikyuusyanmkj;
    }


    @Column(order = 44, label = "支払明細送付先郵便番号")
    private String ifcTsinyno;


    public String getIfcTsinyno() {
        return ifcTsinyno;
    }


    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }


    @Column(order = 45, label = "支払明細送付先通信先住所１（漢字）")
    private String ifcTsinadr1kj;


    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }


    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }


    @Column(order = 46, label = "支払明細送付先通信先住所２（漢字）")
    private String ifcTsinadr2kj;


    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }


    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }


    @Column(order = 47, label = "支払明細送付先通信先住所３（漢字）")
    private String ifcTsinadr3kj;


    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }


    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }


    @Column(order = 48, label = "書類受付日")
    private BizDate ifcSyoruiukeymd;


    public BizDate getIfcSyoruiukeymd() {
        return ifcSyoruiukeymd;
    }


    public void setIfcSyoruiukeymd(BizDate pIfcSyoruiukeymd) {
        ifcSyoruiukeymd = pIfcSyoruiukeymd;
    }


    @Column(order = 49, label = "不備完了日")
    private BizDate ifcHubikanryouymd;


    public BizDate getIfcHubikanryouymd() {
        return ifcHubikanryouymd;
    }


    public void setIfcHubikanryouymd(BizDate pIfcHubikanryouymd) {
        ifcHubikanryouymd = pIfcHubikanryouymd;
    }


    @Column(order = 50, label = "支払結果区分")
    private String ifcHnykshrkekkakbn;


    public String getIfcHnykshrkekkakbn() {
        return ifcHnykshrkekkakbn;
    }


    public void setIfcHnykshrkekkakbn(String pIfcHnykshrkekkakbn) {
        ifcHnykshrkekkakbn = pIfcHnykshrkekkakbn;
    }


    @Column(order = 51, label = "災害非該当区分")
    private C_SaigaiHigaitouKbn ifcSaigaihigaitoukbn;


    public C_SaigaiHigaitouKbn getIfcSaigaihigaitoukbn() {
        return ifcSaigaihigaitoukbn;
    }


    public void setIfcSaigaihigaitoukbn(C_SaigaiHigaitouKbn pIfcSaigaihigaitoukbn) {
        ifcSaigaihigaitoukbn = pIfcSaigaihigaitoukbn;
    }


    @Column(order = 52, label = "支払処理日")
    private BizDate ifcShrsyoriymd;


    public BizDate getIfcShrsyoriymd() {
        return ifcShrsyoriymd;
    }


    public void setIfcShrsyoriymd(BizDate pIfcShrsyoriymd) {
        ifcShrsyoriymd = pIfcShrsyoriymd;
    }


    @Column(order = 53, label = "支払日")
    private BizDate ifcShrymd;


    public BizDate getIfcShrymd() {
        return ifcShrymd;
    }


    public void setIfcShrymd(BizDate pIfcShrymd) {
        ifcShrymd = pIfcShrymd;
    }


    @Column(order = 54, label = "支払金額")
    private BizCurrency ifcShrkgbizc;


    public BizCurrency getIfcShrkgbizc() {
        return ifcShrkgbizc;
    }


    public void setIfcShrkgbizc(BizCurrency pIfcShrkgbizc) {
        ifcShrkgbizc = pIfcShrkgbizc;
    }


    @Column(order = 55, label = "支払通貨種類")
    private C_Tuukasyu ifcShrtuukasyu;


    public C_Tuukasyu getIfcShrtuukasyu() {
        return ifcShrtuukasyu;
    }


    public void setIfcShrtuukasyu(C_Tuukasyu pIfcShrtuukasyu) {
        ifcShrtuukasyu = pIfcShrtuukasyu;
    }


    @Column(order = 56, label = "支払時為替レート")
    private BizNumber ifcShrkwsrate;


    public BizNumber getIfcShrkwsrate() {
        return ifcShrkwsrate;
    }


    public void setIfcShrkwsrate(BizNumber pIfcShrkwsrate) {
        ifcShrkwsrate = pIfcShrkwsrate;
    }


    @Column(order = 57, label = "支払時為替レート基準日")
    private BizDate ifcShrkwsratekjnymd;


    public BizDate getIfcShrkwsratekjnymd() {
        return ifcShrkwsratekjnymd;
    }


    public void setIfcShrkwsratekjnymd(BizDate pIfcShrkwsratekjnymd) {
        ifcShrkwsratekjnymd = pIfcShrkwsratekjnymd;
    }


    @Column(order = 58, label = "外貨換算為替レート")
    private BizNumber ifcGaikaknsnkwsrate;


    public BizNumber getIfcGaikaknsnkwsrate() {
        return ifcGaikaknsnkwsrate;
    }


    public void setIfcGaikaknsnkwsrate(BizNumber pIfcGaikaknsnkwsrate) {
        ifcGaikaknsnkwsrate = pIfcGaikaknsnkwsrate;
    }


    @Column(order = 59, label = "外貨換算為替レート基準日")
    private BizDate ifcGaikaknsnkwsratekjymd;


    public BizDate getIfcGaikaknsnkwsratekjymd() {
        return ifcGaikaknsnkwsratekjymd;
    }


    public void setIfcGaikaknsnkwsratekjymd(BizDate pIfcGaikaknsnkwsratekjymd) {
        ifcGaikaknsnkwsratekjymd = pIfcGaikaknsnkwsratekjymd;
    }


    @Column(order = 60, label = "保険金額合計")
    private BizCurrency ifcHokenkngkgoukeibizc;


    public BizCurrency getIfcHokenkngkgoukeibizc() {
        return ifcHokenkngkgoukeibizc;
    }


    public void setIfcHokenkngkgoukeibizc(BizCurrency pIfcHokenkngkgoukeibizc) {
        ifcHokenkngkgoukeibizc = pIfcHokenkngkgoukeibizc;
    }


    @Column(order = 61, label = "配当金")
    private BizCurrency ifcHaitoukinbizc;


    public BizCurrency getIfcHaitoukinbizc() {
        return ifcHaitoukinbizc;
    }


    public void setIfcHaitoukinbizc(BizCurrency pIfcHaitoukinbizc) {
        ifcHaitoukinbizc = pIfcHaitoukinbizc;
    }


    @Column(order = 62, label = "その他配当金")
    private BizCurrency ifcSonotahaitoukinbizc;


    public BizCurrency getIfcSonotahaitoukinbizc() {
        return ifcSonotahaitoukinbizc;
    }


    public void setIfcSonotahaitoukinbizc(BizCurrency pIfcSonotahaitoukinbizc) {
        ifcSonotahaitoukinbizc = pIfcSonotahaitoukinbizc;
    }


    @Column(order = 63, label = "未収保険料")
    private BizCurrency ifcMisyuupbizc;


    public BizCurrency getIfcMisyuupbizc() {
        return ifcMisyuupbizc;
    }


    public void setIfcMisyuupbizc(BizCurrency pIfcMisyuupbizc) {
        ifcMisyuupbizc = pIfcMisyuupbizc;
    }


    @Column(order = 64, label = "未経過保険料")
    private BizCurrency ifcMikeikapbizc;


    public BizCurrency getIfcMikeikapbizc() {
        return ifcMikeikapbizc;
    }


    public void setIfcMikeikapbizc(BizCurrency pIfcMikeikapbizc) {
        ifcMikeikapbizc = pIfcMikeikapbizc;
    }


    @Column(order = 65, label = "前納精算金額")
    private BizCurrency ifcZennouseisankgkbizc;


    public BizCurrency getIfcZennouseisankgkbizc() {
        return ifcZennouseisankgkbizc;
    }


    public void setIfcZennouseisankgkbizc(BizCurrency pIfcZennouseisankgkbizc) {
        ifcZennouseisankgkbizc = pIfcZennouseisankgkbizc;
    }


    @Column(order = 66, label = "預り金額")
    private BizCurrency ifcAzukarikingkbizc;


    public BizCurrency getIfcAzukarikingkbizc() {
        return ifcAzukarikingkbizc;
    }


    public void setIfcAzukarikingkbizc(BizCurrency pIfcAzukarikingkbizc) {
        ifcAzukarikingkbizc = pIfcAzukarikingkbizc;
    }


    @Column(order = 67, label = "仮受金額")
    private BizCurrency ifcKrkgkbizc;


    public BizCurrency getIfcKrkgkbizc() {
        return ifcKrkgkbizc;
    }


    public void setIfcKrkgkbizc(BizCurrency pIfcKrkgkbizc) {
        ifcKrkgkbizc = pIfcKrkgkbizc;
    }


    @Column(order = 68, label = "支払遅延利息")
    private BizCurrency ifcShrtienrskbizc;


    public BizCurrency getIfcShrtienrskbizc() {
        return ifcShrtienrskbizc;
    }


    public void setIfcShrtienrskbizc(BizCurrency pIfcShrtienrskbizc) {
        ifcShrtienrskbizc = pIfcShrtienrskbizc;
    }


    @Column(order = 69, label = "円換算支払金額")
    private BizCurrency ifcYenshrgkbizc;


    public BizCurrency getIfcYenshrgkbizc() {
        return ifcYenshrgkbizc;
    }


    public void setIfcYenshrgkbizc(BizCurrency pIfcYenshrgkbizc) {
        ifcYenshrgkbizc = pIfcYenshrgkbizc;
    }


    @Column(order = 70, label = "円換算保険金額合計")
    private BizCurrency ifcYenhkgkgoukeibizc;


    public BizCurrency getIfcYenhkgkgoukeibizc() {
        return ifcYenhkgkgoukeibizc;
    }


    public void setIfcYenhkgkgoukeibizc(BizCurrency pIfcYenhkgkgoukeibizc) {
        ifcYenhkgkgoukeibizc = pIfcYenhkgkgoukeibizc;
    }


    @Column(order = 71, label = "円貨配当金")
    private BizCurrency ifcYenkahaitoukinbizc;


    public BizCurrency getIfcYenkahaitoukinbizc() {
        return ifcYenkahaitoukinbizc;
    }


    public void setIfcYenkahaitoukinbizc(BizCurrency pIfcYenkahaitoukinbizc) {
        ifcYenkahaitoukinbizc = pIfcYenkahaitoukinbizc;
    }


    @Column(order = 72, label = "円貨その他配当金")
    private BizCurrency ifcYenkasonotahaitoukinbizc;


    public BizCurrency getIfcYenkasonotahaitoukinbizc() {
        return ifcYenkasonotahaitoukinbizc;
    }


    public void setIfcYenkasonotahaitoukinbizc(BizCurrency pIfcYenkasonotahaitoukinbizc) {
        ifcYenkasonotahaitoukinbizc = pIfcYenkasonotahaitoukinbizc;
    }


    @Column(order = 73, label = "円貨未収保険料")
    private BizCurrency ifcYenkamisyuupbizc;


    public BizCurrency getIfcYenkamisyuupbizc() {
        return ifcYenkamisyuupbizc;
    }


    public void setIfcYenkamisyuupbizc(BizCurrency pIfcYenkamisyuupbizc) {
        ifcYenkamisyuupbizc = pIfcYenkamisyuupbizc;
    }


    @Column(order = 74, label = "円貨未経過保険料")
    private BizCurrency ifcYenkamikeikapbizc;


    public BizCurrency getIfcYenkamikeikapbizc() {
        return ifcYenkamikeikapbizc;
    }


    public void setIfcYenkamikeikapbizc(BizCurrency pIfcYenkamikeikapbizc) {
        ifcYenkamikeikapbizc = pIfcYenkamikeikapbizc;
    }


    @Column(order = 75, label = "円貨前納精算金額")
    private BizCurrency ifcYenkazennouseisankgkbizc;


    public BizCurrency getIfcYenkazennouseisankgkbizc() {
        return ifcYenkazennouseisankgkbizc;
    }


    public void setIfcYenkazennouseisankgkbizc(BizCurrency pIfcYenkazennouseisankgkbizc) {
        ifcYenkazennouseisankgkbizc = pIfcYenkazennouseisankgkbizc;
    }


    @Column(order = 76, label = "円貨預り金額")
    private BizCurrency ifcYenkaazukarikingkbizc;


    public BizCurrency getIfcYenkaazukarikingkbizc() {
        return ifcYenkaazukarikingkbizc;
    }


    public void setIfcYenkaazukarikingkbizc(BizCurrency pIfcYenkaazukarikingkbizc) {
        ifcYenkaazukarikingkbizc = pIfcYenkaazukarikingkbizc;
    }


    @Column(order = 77, label = "円貨仮受金額")
    private BizCurrency ifcYenkakrkgkbizc;


    public BizCurrency getIfcYenkakrkgkbizc() {
        return ifcYenkakrkgkbizc;
    }


    public void setIfcYenkakrkgkbizc(BizCurrency pIfcYenkakrkgkbizc) {
        ifcYenkakrkgkbizc = pIfcYenkakrkgkbizc;
    }


    @Column(order = 78, label = "円換算支払遅延利息")
    private BizCurrency ifcYenshrtienrskbizc;


    public BizCurrency getIfcYenshrtienrskbizc() {
        return ifcYenshrtienrskbizc;
    }


    public void setIfcYenshrtienrskbizc(BizCurrency pIfcYenshrtienrskbizc) {
        ifcYenshrtienrskbizc = pIfcYenshrtienrskbizc;
    }


    @Column(order = 79, label = "税適預り金額（指定通貨）")
    private BizCurrency ifcZitkazkrknsiteituukabizc;


    public BizCurrency getIfcZitkazkrknsiteituukabizc() {
        return ifcZitkazkrknsiteituukabizc;
    }


    public void setIfcZitkazkrknsiteituukabizc(BizCurrency pIfcZitkazkrknsiteituukabizc) {
        ifcZitkazkrknsiteituukabizc = pIfcZitkazkrknsiteituukabizc;
    }


    @Column(order = 80, label = "税適預り金額（円貨）")
    private BizCurrency ifcZitkazukarikingkyenbizc;


    public BizCurrency getIfcZitkazukarikingkyenbizc() {
        return ifcZitkazukarikingkyenbizc;
    }


    public void setIfcZitkazukarikingkyenbizc(BizCurrency pIfcZitkazukarikingkyenbizc) {
        ifcZitkazukarikingkyenbizc = pIfcZitkazukarikingkyenbizc;
    }


    @Column(order = 81, label = "外貨換算対象金額")
    private BizCurrency ifcGaikaknsntkgkbizc;


    public BizCurrency getIfcGaikaknsntkgkbizc() {
        return ifcGaikaknsntkgkbizc;
    }


    public void setIfcGaikaknsntkgkbizc(BizCurrency pIfcGaikaknsntkgkbizc) {
        ifcGaikaknsntkgkbizc = pIfcGaikaknsntkgkbizc;
    }


    @Column(order = 82, label = "外貨換算結果金額")
    private BizCurrency ifcGaikaknsnkekkakgkbizc;


    public BizCurrency getIfcGaikaknsnkekkakgkbizc() {
        return ifcGaikaknsnkekkakgkbizc;
    }


    public void setIfcGaikaknsnkekkakgkbizc(BizCurrency pIfcGaikaknsnkekkakgkbizc) {
        ifcGaikaknsnkekkakgkbizc = pIfcGaikaknsnkekkakgkbizc;
    }


    @Column(order = 83, label = "円貨換算対象金額")
    private BizCurrency ifcYenkaknsntkgkbizc;


    public BizCurrency getIfcYenkaknsntkgkbizc() {
        return ifcYenkaknsntkgkbizc;
    }


    public void setIfcYenkaknsntkgkbizc(BizCurrency pIfcYenkaknsntkgkbizc) {
        ifcYenkaknsntkgkbizc = pIfcYenkaknsntkgkbizc;
    }


    @Column(order = 84, label = "円貨換算結果金額")
    private BizCurrency ifcYenkaknsnkekkakgkbizc;


    public BizCurrency getIfcYenkaknsnkekkakgkbizc() {
        return ifcYenkaknsnkekkakgkbizc;
    }


    public void setIfcYenkaknsnkekkakgkbizc(BizCurrency pIfcYenkaknsnkekkakgkbizc) {
        ifcYenkaknsnkekkakgkbizc = pIfcYenkaknsnkekkakgkbizc;
    }


    @Column(order = 85, label = "指定通貨")
    private C_Tuukasyu ifcKyktuukasyukbn;


    public C_Tuukasyu getIfcKyktuukasyukbn() {
        return ifcKyktuukasyukbn;
    }


    public void setIfcKyktuukasyukbn(C_Tuukasyu pIfcKyktuukasyukbn) {
        ifcKyktuukasyukbn = pIfcKyktuukasyukbn;
    }


    @Column(order = 86, label = "支払方法")
    private String ifcShrhou;


    public String getIfcShrhou() {
        return ifcShrhou;
    }


    public void setIfcShrhou(String pIfcShrhou) {
        ifcShrhou = pIfcShrhou;
    }


    @Column(order = 87, label = "税務用為替レート")
    private BizNumber ifcZeimukwsrate;


    public BizNumber getIfcZeimukwsrate() {
        return ifcZeimukwsrate;
    }


    public void setIfcZeimukwsrate(BizNumber pIfcZeimukwsrate) {
        ifcZeimukwsrate = pIfcZeimukwsrate;
    }


    @Column(order = 88, label = "税務用為替レート基準日")
    private BizDate ifcZeimukwsratekjnymd;


    public BizDate getIfcZeimukwsratekjnymd() {
        return ifcZeimukwsratekjnymd;
    }


    public void setIfcZeimukwsratekjnymd(BizDate pIfcZeimukwsratekjnymd) {
        ifcZeimukwsratekjnymd = pIfcZeimukwsratekjnymd;
    }


    @Column(order = 89, label = "税取扱区分")
    private String ifcHnykzeitratkikbn;


    public String getIfcHnykzeitratkikbn() {
        return ifcHnykzeitratkikbn;
    }


    public void setIfcHnykzeitratkikbn(String pIfcHnykzeitratkikbn) {
        ifcHnykzeitratkikbn = pIfcHnykzeitratkikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
