package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）非該当一覧リスト データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiHigaitouItiranLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiHigaitouItiranLayoutFile() {
    }


    @Column(order = 1, label = "請求区分")
    @NotNull
    private String ifcSeikyuukbn;


    public String getIfcSeikyuukbn() {
        return ifcSeikyuukbn;
    }


    public void setIfcSeikyuukbn(String pIfcSeikyuukbn) {
        ifcSeikyuukbn = pIfcSeikyuukbn;
    }


    @Column(order = 2, label = "査定結果")
    private String ifcSateikekka;


    public String getIfcSateikekka() {
        return ifcSateikekka;
    }


    public void setIfcSateikekka(String pIfcSateikekka) {
        ifcSateikekka = pIfcSateikekka;
    }


    @Column(order = 3, label = "非該当原因")
    private String ifcHigaitougenin;


    public String getIfcHigaitougenin() {
        return ifcHigaitougenin;
    }


    public void setIfcHigaitougenin(String pIfcHigaitougenin) {
        ifcHigaitougenin = pIfcHigaitougenin;
    }


    @Column(order = 4, label = "決裁年月日")
    private BizDate ifcKessaiymd;


    public BizDate getIfcKessaiymd() {
        return ifcKessaiymd;
    }


    public void setIfcKessaiymd(BizDate pIfcKessaiymd) {
        ifcKessaiymd = pIfcKessaiymd;
    }


    @Column(order = 5, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 6, label = "保険名称")
    private String ifcHknnm;


    public String getIfcHknnm() {
        return ifcHknnm;
    }


    public void setIfcHknnm(String pIfcHknnm) {
        ifcHknnm = pIfcHknnm;
    }


    @Column(order = 7, label = "被保険者名フリガナ")
    private String ifcHhknnmkn;


    public String getIfcHhknnmkn() {
        return ifcHhknnmkn;
    }


    public void setIfcHhknnmkn(String pIfcHhknnmkn) {
        ifcHhknnmkn = pIfcHhknnmkn;
    }


    @Column(order = 8, label = "取次支社")
    private String ifcToritugisisya;


    public String getIfcToritugisisya() {
        return ifcToritugisisya;
    }


    public void setIfcToritugisisya(String pIfcToritugisisya) {
        ifcToritugisisya = pIfcToritugisisya;
    }


    @Column(order = 9, label = "契約年月日")
    private BizDate ifcKykymd;


    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }


    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }


    @Column(order = 10, label = "死亡保険金額")
    private String ifcSbs;


    public String getIfcSbs() {
        return ifcSbs;
    }


    public void setIfcSbs(String pIfcSbs) {
        ifcSbs = pIfcSbs;
    }


    @Column(order = 11, label = "災害死亡保険金額")
    private String ifcSaigaisbs;


    public String getIfcSaigaisbs() {
        return ifcSaigaisbs;
    }


    public void setIfcSaigaisbs(String pIfcSaigaisbs) {
        ifcSaigaisbs = pIfcSaigaisbs;
    }


    @Column(order = 12, label = "死亡年月日")
    private BizDate ifcSbymd;


    public BizDate getIfcSbymd() {
        return ifcSbymd;
    }


    public void setIfcSbymd(BizDate pIfcSbymd) {
        ifcSbymd = pIfcSbymd;
    }


    @Column(order = 13, label = "死因")
    private String ifcSiin;


    public String getIfcSiin() {
        return ifcSiin;
    }


    public void setIfcSiin(String pIfcSiin) {
        ifcSiin = pIfcSiin;
    }


    @Column(order = 14, label = "直接死因")
    private String ifcTyokusetusiin;


    public String getIfcTyokusetusiin() {
        return ifcTyokusetusiin;
    }


    public void setIfcTyokusetusiin(String pIfcTyokusetusiin) {
        ifcTyokusetusiin = pIfcTyokusetusiin;
    }


    @Column(order = 15, label = "一次決裁者")
    private String ifcItijikessainm;


    public String getIfcItijikessainm() {
        return ifcItijikessainm;
    }


    public void setIfcItijikessainm(String pIfcItijikessainm) {
        ifcItijikessainm = pIfcItijikessainm;
    }


    @Column(order = 16, label = "確認有無")
    private String ifcKakninumukbn;


    public String getIfcKakninumukbn() {
        return ifcKakninumukbn;
    }


    public void setIfcKakninumukbn(String pIfcKakninumukbn) {
        ifcKakninumukbn = pIfcKakninumukbn;
    }


    @Column(order = 17, label = "延伸区分")
    private String ifcSinsagendokknkbn;


    public String getIfcSinsagendokknkbn() {
        return ifcSinsagendokknkbn;
    }


    public void setIfcSinsagendokknkbn(String pIfcSinsagendokknkbn) {
        ifcSinsagendokknkbn = pIfcSinsagendokknkbn;
    }


    @Column(order = 18, label = "中断日数")
    private Integer ifcTdnnissuu;


    public Integer getIfcTdnnissuu() {
        return ifcTdnnissuu;
    }


    public void setIfcTdnnissuu(Integer pIfcTdnnissuu) {
        ifcTdnnissuu = pIfcTdnnissuu;
    }


    @Column(order = 19, label = "災害申出有無")
    private String ifcSaigaimousideumu;


    public String getIfcSaigaimousideumu() {
        return ifcSaigaimousideumu;
    }


    public void setIfcSaigaimousideumu(String pIfcSaigaimousideumu) {
        ifcSaigaimousideumu = pIfcSaigaimousideumu;
    }


    @Column(order = 20, label = "解決年月日")
    private BizDate ifcKaiketuymd;


    public BizDate getIfcKaiketuymd() {
        return ifcKaiketuymd;
    }


    public void setIfcKaiketuymd(BizDate pIfcKaiketuymd) {
        ifcKaiketuymd = pIfcKaiketuymd;
    }


    @Column(order = 21, label = "書類受付日")
    private BizDate ifcSyoruiukeymd;


    public BizDate getIfcSyoruiukeymd() {
        return ifcSyoruiukeymd;
    }


    public void setIfcSyoruiukeymd(BizDate pIfcSyoruiukeymd) {
        ifcSyoruiukeymd = pIfcSyoruiukeymd;
    }


    @Column(order = 22, label = "折衝有無")
    private String ifcSessyouumu;


    public String getIfcSessyouumu() {
        return ifcSessyouumu;
    }


    public void setIfcSessyouumu(String pIfcSessyouumu) {
        ifcSessyouumu = pIfcSessyouumu;
    }


    @Column(order = 23, label = "折衝支社")
    private String ifcSessyousisyacd;


    public String getIfcSessyousisyacd() {
        return ifcSessyousisyacd;
    }


    public void setIfcSessyousisyacd(String pIfcSessyousisyacd) {
        ifcSessyousisyacd = pIfcSessyousisyacd;
    }


    @Column(order = 24, label = "折衝支社名")
    private String ifcSessyousisyanm;


    public String getIfcSessyousisyanm() {
        return ifcSessyousisyanm;
    }


    public void setIfcSessyousisyanm(String pIfcSessyousisyanm) {
        ifcSessyousisyanm = pIfcSessyousisyanm;
    }


    @Column(order = 25, label = "名義変更査定")
    private String ifcMeigihnk;


    public String getIfcMeigihnk() {
        return ifcMeigihnk;
    }


    public void setIfcMeigihnk(String pIfcMeigihnk) {
        ifcMeigihnk = pIfcMeigihnk;
    }


    @Column(order = 26, label = "取扱不良・不祥事件等有無")
    private String ifcTratkihuryouumu;


    public String getIfcTratkihuryouumu() {
        return ifcTratkihuryouumu;
    }


    public void setIfcTratkihuryouumu(String pIfcTratkihuryouumu) {
        ifcTratkihuryouumu = pIfcTratkihuryouumu;
    }


    @Column(order = 27, label = "弁護士見解有無")
    private String ifcBengosikenkaiumu;


    public String getIfcBengosikenkaiumu() {
        return ifcBengosikenkaiumu;
    }


    public void setIfcBengosikenkaiumu(String pIfcBengosikenkaiumu) {
        ifcBengosikenkaiumu = pIfcBengosikenkaiumu;
    }


    @Column(order = 28, label = "苦情有無")
    private String ifcKujyouumukbn;


    public String getIfcKujyouumukbn() {
        return ifcKujyouumukbn;
    }


    public void setIfcKujyouumukbn(String pIfcKujyouumukbn) {
        ifcKujyouumukbn = pIfcKujyouumukbn;
    }


    @Column(order = 29, label = "事務ミス有無")
    private String ifcJimumissumu;


    public String getIfcJimumissumu() {
        return ifcJimumissumu;
    }


    public void setIfcJimumissumu(String pIfcJimumissumu) {
        ifcJimumissumu = pIfcJimumissumu;
    }


    @Column(order = 30, label = "診断書料支払要否")
    private String ifcSindansyoryoushryouhi;


    public String getIfcSindansyoryoushryouhi() {
        return ifcSindansyoryoushryouhi;
    }


    public void setIfcSindansyoryoushryouhi(String pIfcSindansyoryoushryouhi) {
        ifcSindansyoryoushryouhi = pIfcSindansyoryoushryouhi;
    }


    @Column(order = 31, label = "災Ｓ非該当区分")
    private String ifcSaiesuhigaitoukbn;


    public String getIfcSaiesuhigaitoukbn() {
        return ifcSaiesuhigaitoukbn;
    }


    public void setIfcSaiesuhigaitoukbn(String pIfcSaiesuhigaitoukbn) {
        ifcSaiesuhigaitoukbn = pIfcSaiesuhigaitoukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
