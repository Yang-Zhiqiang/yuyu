package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Kktyhysksitisy;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;

/**
 * （共通）専用帳票一括印刷送信ファイル（控除証明書レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzIkkatuinsatuKoujyoSymLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzIkkatuinsatuKoujyoSymLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）レコード区分")
    private String ifcRecordkbn;

    public String getIfcRecordkbn() {
        return ifcRecordkbn;
    }

    public void setIfcRecordkbn(String pIfcRecordkbn) {
        ifcRecordkbn = pIfcRecordkbn;
    }

    @Column(order = 2, label = "（ＩＦｃ）書類コード")
    private String ifcSyoruicd;

    public String getIfcSyoruicd() {
        return ifcSyoruicd;
    }

    public void setIfcSyoruicd(String pIfcSyoruicd) {
        ifcSyoruicd = pIfcSyoruicd;
    }

    @Column(order = 3, label = "（ＩＦｃ）一連番号")
    private String ifcItirenno;

    public String getIfcItirenno() {
        return ifcItirenno;
    }

    public void setIfcItirenno(String pIfcItirenno) {
        ifcItirenno = pIfcItirenno;
    }

    @Column(order = 4, label = "（ＩＦｃ）証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 5, label = "（ＩＦｃ）帳票作成日")
    private BizDate ifcTyouhyousakuseiymd;

    public BizDate getIfcTyouhyousakuseiymd() {
        return ifcTyouhyousakuseiymd;
    }

    public void setIfcTyouhyousakuseiymd(BizDate pIfcTyouhyousakuseiymd) {
        ifcTyouhyousakuseiymd = pIfcTyouhyousakuseiymd;
    }

    @Column(order = 6, label = "（ＩＦｃ）年度")
    private String ifcNendo;

    public String getIfcNendo() {
        return ifcNendo;
    }

    public void setIfcNendo(String pIfcNendo) {
        ifcNendo = pIfcNendo;
    }

    @Column(order = 7, label = "（ＩＦｃ）適用制度区分")
    private C_TekiyouseidoKbn ifcTekiyouseidokbn;

    public C_TekiyouseidoKbn getIfcTekiyouseidokbn() {
        return ifcTekiyouseidokbn;
    }

    public void setIfcTekiyouseidokbn(C_TekiyouseidoKbn pIfcTekiyouseidokbn) {
        ifcTekiyouseidokbn = pIfcTekiyouseidokbn;
    }

    @Column(order = 8, label = "（ＩＦｃ）契約管理帳票作成対象区分")
    private C_Kktyhysksitisy ifcKktyhysksitisykbn;

    public C_Kktyhysksitisy getIfcKktyhysksitisykbn() {
        return ifcKktyhysksitisykbn;
    }

    public void setIfcKktyhysksitisykbn(C_Kktyhysksitisy pIfcKktyhysksitisykbn) {
        ifcKktyhysksitisykbn = pIfcKktyhysksitisykbn;
    }

    @Column(order = 9, label = "（ＩＦｃ）証明日")
    private String ifcSyoumeiymd;

    public String getIfcSyoumeiymd() {
        return ifcSyoumeiymd;
    }

    public void setIfcSyoumeiymd(String pIfcSyoumeiymd) {
        ifcSyoumeiymd = pIfcSyoumeiymd;
    }

    @Column(order = 10, label = "（ＩＦｃ）証明開始年月")
    private BizDateYM ifcSyoumeistartym;

    public BizDateYM getIfcSyoumeistartym() {
        return ifcSyoumeistartym;
    }

    public void setIfcSyoumeistartym(BizDateYM pIfcSyoumeistartym) {
        ifcSyoumeistartym = pIfcSyoumeistartym;
    }

    @Column(order = 11, label = "（ＩＦｃ）証明終了年月")
    private BizDateYM ifcSyoumeiendym;

    public BizDateYM getIfcSyoumeiendym() {
        return ifcSyoumeiendym;
    }

    public void setIfcSyoumeiendym(BizDateYM pIfcSyoumeiendym) {
        ifcSyoumeiendym = pIfcSyoumeiendym;
    }

    @Column(order = 12, label = "（ＩＦｃ）証明期間月数")
    private Integer ifcSyoumeikkntukisuu;

    public Integer getIfcSyoumeikkntukisuu() {
        return ifcSyoumeikkntukisuu;
    }

    public void setIfcSyoumeikkntukisuu(Integer pIfcSyoumeikkntukisuu) {
        ifcSyoumeikkntukisuu = pIfcSyoumeikkntukisuu;
    }

    @Column(order = 13, label = "（ＩＦｃ）契約者名（漢字）")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 14, label = "（ＩＦｃ）保険種類略称（漢字）")
    private String ifcHknsyuruinmrykkj;

    public String getIfcHknsyuruinmrykkj() {
        return ifcHknsyuruinmrykkj;
    }

    public void setIfcHknsyuruinmrykkj(String pIfcHknsyuruinmrykkj) {
        ifcHknsyuruinmrykkj = pIfcHknsyuruinmrykkj;
    }

    @Column(order = 15, label = "（ＩＦｃ）契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 16, label = "（ＩＦｃ）保険期間歳満期区分（主契約）")
    private C_HknkknsmnKbn ifcHknkknsmnkbnsyu;

    public C_HknkknsmnKbn getIfcHknkknsmnkbnsyu() {
        return ifcHknkknsmnkbnsyu;
    }

    public void setIfcHknkknsmnkbnsyu(C_HknkknsmnKbn pIfcHknkknsmnkbnsyu) {
        ifcHknkknsmnkbnsyu = pIfcHknkknsmnkbnsyu;
    }

    @Column(order = 17, label = "（ＩＦｃ）保険期間（主契約）")
    private BizNumber ifcHknkkssyu;

    public BizNumber getIfcHknkkssyu() {
        return ifcHknkkssyu;
    }

    public void setIfcHknkkssyu(BizNumber pIfcHknkkssyu) {
        ifcHknkkssyu = pIfcHknkkssyu;
    }

    @Column(order = 18, label = "（ＩＦｃ）年間払込回数")
    private Integer ifcNenkanhrkkaisuu;

    public Integer getIfcNenkanhrkkaisuu() {
        return ifcNenkanhrkkaisuu;
    }

    public void setIfcNenkanhrkkaisuu(Integer pIfcNenkanhrkkaisuu) {
        ifcNenkanhrkkaisuu = pIfcNenkanhrkkaisuu;
    }

    @Column(order = 19, label = "（ＩＦｃ）契約状態")
    private C_Kykjyoutai ifcKykjyoutai;

    public C_Kykjyoutai getIfcKykjyoutai() {
        return ifcKykjyoutai;
    }

    public void setIfcKykjyoutai(C_Kykjyoutai pIfcKykjyoutai) {
        ifcKykjyoutai = pIfcKykjyoutai;
    }

    @Column(order = 20, label = "（ＩＦｃ）旧制度一般実績保険料")
    private String ifcOldippanjissekip;

    public String getIfcOldippanjissekip() {
        return ifcOldippanjissekip;
    }

    public void setIfcOldippanjissekip(String pIfcOldippanjissekip) {
        ifcOldippanjissekip = pIfcOldippanjissekip;
    }

    @Column(order = 21, label = "（ＩＦｃ）旧制度一般年間保険料")
    private String ifcOldippannenkanp;

    public String getIfcOldippannenkanp() {
        return ifcOldippannenkanp;
    }

    public void setIfcOldippannenkanp(String pIfcOldippannenkanp) {
        ifcOldippannenkanp = pIfcOldippannenkanp;
    }

    @Column(order = 22, label = "（ＩＦｃ）旧制度一般実績配当金")
    private String ifcOldippanjissekihaitoukin;

    public String getIfcOldippanjissekihaitoukin() {
        return ifcOldippanjissekihaitoukin;
    }

    public void setIfcOldippanjissekihaitoukin(String pIfcOldippanjissekihaitoukin) {
        ifcOldippanjissekihaitoukin = pIfcOldippanjissekihaitoukin;
    }

    @Column(order = 23, label = "（ＩＦｃ）旧制度一般年間配当金")
    private String ifcOldippannenkanhaitoukin;

    public String getIfcOldippannenkanhaitoukin() {
        return ifcOldippannenkanhaitoukin;
    }

    public void setIfcOldippannenkanhaitoukin(String pIfcOldippannenkanhaitoukin) {
        ifcOldippannenkanhaitoukin = pIfcOldippannenkanhaitoukin;
    }

    @Column(order = 24, label = "（ＩＦｃ）旧制度一般実績証明額")
    private String ifcOldippanjissekisyoumeigk;

    public String getIfcOldippanjissekisyoumeigk() {
        return ifcOldippanjissekisyoumeigk;
    }

    public void setIfcOldippanjissekisyoumeigk(String pIfcOldippanjissekisyoumeigk) {
        ifcOldippanjissekisyoumeigk = pIfcOldippanjissekisyoumeigk;
    }

    @Column(order = 25, label = "（ＩＦｃ）旧制度一般年間証明額")
    private String ifcOldippannenkansyoumeigk;

    public String getIfcOldippannenkansyoumeigk() {
        return ifcOldippannenkansyoumeigk;
    }

    public void setIfcOldippannenkansyoumeigk(String pIfcOldippannenkansyoumeigk) {
        ifcOldippannenkansyoumeigk = pIfcOldippannenkansyoumeigk;
    }

    @Column(order = 26, label = "（ＩＦｃ）新制度一般実績保険料")
    private String ifcNewippanjissekip;

    public String getIfcNewippanjissekip() {
        return ifcNewippanjissekip;
    }

    public void setIfcNewippanjissekip(String pIfcNewippanjissekip) {
        ifcNewippanjissekip = pIfcNewippanjissekip;
    }

    @Column(order = 27, label = "（ＩＦｃ）新制度一般年間保険料")
    private String ifcNewippannenkanp;

    public String getIfcNewippannenkanp() {
        return ifcNewippannenkanp;
    }

    public void setIfcNewippannenkanp(String pIfcNewippannenkanp) {
        ifcNewippannenkanp = pIfcNewippannenkanp;
    }

    @Column(order = 28, label = "（ＩＦｃ）新制度一般実績配当金")
    private String ifcNewippanjissekihaitoukin;

    public String getIfcNewippanjissekihaitoukin() {
        return ifcNewippanjissekihaitoukin;
    }

    public void setIfcNewippanjissekihaitoukin(String pIfcNewippanjissekihaitoukin) {
        ifcNewippanjissekihaitoukin = pIfcNewippanjissekihaitoukin;
    }

    @Column(order = 29, label = "（ＩＦｃ）新制度一般年間配当金")
    private String ifcNewippannenkanhaitoukin;

    public String getIfcNewippannenkanhaitoukin() {
        return ifcNewippannenkanhaitoukin;
    }

    public void setIfcNewippannenkanhaitoukin(String pIfcNewippannenkanhaitoukin) {
        ifcNewippannenkanhaitoukin = pIfcNewippannenkanhaitoukin;
    }

    @Column(order = 30, label = "（ＩＦｃ）新制度一般実績証明額")
    private String ifcNewippanjissekisyoumeigk;

    public String getIfcNewippanjissekisyoumeigk() {
        return ifcNewippanjissekisyoumeigk;
    }

    public void setIfcNewippanjissekisyoumeigk(String pIfcNewippanjissekisyoumeigk) {
        ifcNewippanjissekisyoumeigk = pIfcNewippanjissekisyoumeigk;
    }

    @Column(order = 31, label = "（ＩＦｃ）新制度一般年間証明額")
    private String ifcNewippannenkansyoumeigk;

    public String getIfcNewippannenkansyoumeigk() {
        return ifcNewippannenkansyoumeigk;
    }

    public void setIfcNewippannenkansyoumeigk(String pIfcNewippannenkansyoumeigk) {
        ifcNewippannenkansyoumeigk = pIfcNewippannenkansyoumeigk;
    }

    @Column(order = 32, label = "（ＩＦｃ）新制度介護医療実績保険料")
    private String ifcNewiryoujissekip;

    public String getIfcNewiryoujissekip() {
        return ifcNewiryoujissekip;
    }

    public void setIfcNewiryoujissekip(String pIfcNewiryoujissekip) {
        ifcNewiryoujissekip = pIfcNewiryoujissekip;
    }

    @Column(order = 33, label = "（ＩＦｃ）新制度介護医療年間保険料")
    private String ifcNewiryounenkanp;

    public String getIfcNewiryounenkanp() {
        return ifcNewiryounenkanp;
    }

    public void setIfcNewiryounenkanp(String pIfcNewiryounenkanp) {
        ifcNewiryounenkanp = pIfcNewiryounenkanp;
    }

    @Column(order = 34, label = "（ＩＦｃ）新制度介護医療実績配当金")
    private String ifcNewiryoujissekihaitoukin;

    public String getIfcNewiryoujissekihaitoukin() {
        return ifcNewiryoujissekihaitoukin;
    }

    public void setIfcNewiryoujissekihaitoukin(String pIfcNewiryoujissekihaitoukin) {
        ifcNewiryoujissekihaitoukin = pIfcNewiryoujissekihaitoukin;
    }

    @Column(order = 35, label = "（ＩＦｃ）新制度介護医療年間配当金")
    private String ifcNewiryounenkanhaitoukin;

    public String getIfcNewiryounenkanhaitoukin() {
        return ifcNewiryounenkanhaitoukin;
    }

    public void setIfcNewiryounenkanhaitoukin(String pIfcNewiryounenkanhaitoukin) {
        ifcNewiryounenkanhaitoukin = pIfcNewiryounenkanhaitoukin;
    }

    @Column(order = 36, label = "（ＩＦｃ）新制度介護医療実績証明額")
    private String ifcNewiryoujissekisyoumeigk;

    public String getIfcNewiryoujissekisyoumeigk() {
        return ifcNewiryoujissekisyoumeigk;
    }

    public void setIfcNewiryoujissekisyoumeigk(String pIfcNewiryoujissekisyoumeigk) {
        ifcNewiryoujissekisyoumeigk = pIfcNewiryoujissekisyoumeigk;
    }

    @Column(order = 37, label = "（ＩＦｃ）新制度介護医療年間証明額")
    private String ifcNewiryounenkansyoumeigk;

    public String getIfcNewiryounenkansyoumeigk() {
        return ifcNewiryounenkansyoumeigk;
    }

    public void setIfcNewiryounenkansyoumeigk(String pIfcNewiryounenkansyoumeigk) {
        ifcNewiryounenkansyoumeigk = pIfcNewiryounenkansyoumeigk;
    }

    @Column(order = 38, label = "（ＩＦｃ）新制度年金実績保険料")
    private String ifcNewnkjissekip;

    public String getIfcNewnkjissekip() {
        return ifcNewnkjissekip;
    }

    public void setIfcNewnkjissekip(String pIfcNewnkjissekip) {
        ifcNewnkjissekip = pIfcNewnkjissekip;
    }

    @Column(order = 39, label = "（ＩＦｃ）新制度年金年間保険料")
    private String ifcNewnknenkanp;

    public String getIfcNewnknenkanp() {
        return ifcNewnknenkanp;
    }

    public void setIfcNewnknenkanp(String pIfcNewnknenkanp) {
        ifcNewnknenkanp = pIfcNewnknenkanp;
    }

    @Column(order = 40, label = "（ＩＦｃ）新制度年金実績配当金")
    private String ifcNewnkjissekihaitoukin;

    public String getIfcNewnkjissekihaitoukin() {
        return ifcNewnkjissekihaitoukin;
    }

    public void setIfcNewnkjissekihaitoukin(String pIfcNewnkjissekihaitoukin) {
        ifcNewnkjissekihaitoukin = pIfcNewnkjissekihaitoukin;
    }

    @Column(order = 41, label = "（ＩＦｃ）新制度年金年間配当金")
    private String ifcNewnknenkanhaitoukin;

    public String getIfcNewnknenkanhaitoukin() {
        return ifcNewnknenkanhaitoukin;
    }

    public void setIfcNewnknenkanhaitoukin(String pIfcNewnknenkanhaitoukin) {
        ifcNewnknenkanhaitoukin = pIfcNewnknenkanhaitoukin;
    }

    @Column(order = 42, label = "（ＩＦｃ）新制度年金実績証明額")
    private String ifcNewnkjissekisyoumeigk;

    public String getIfcNewnkjissekisyoumeigk() {
        return ifcNewnkjissekisyoumeigk;
    }

    public void setIfcNewnkjissekisyoumeigk(String pIfcNewnkjissekisyoumeigk) {
        ifcNewnkjissekisyoumeigk = pIfcNewnkjissekisyoumeigk;
    }

    @Column(order = 43, label = "（ＩＦｃ）新制度年金年間証明額")
    private String ifcNewnknenkansyoumeigk;

    public String getIfcNewnknenkansyoumeigk() {
        return ifcNewnknenkansyoumeigk;
    }

    public void setIfcNewnknenkansyoumeigk(String pIfcNewnknenkansyoumeigk) {
        ifcNewnknenkansyoumeigk = pIfcNewnknenkansyoumeigk;
    }

    @Column(order = 44, label = "（ＩＦｃ）通信先郵便番号")
    private String ifcTsinyno;

    public String getIfcTsinyno() {
        return ifcTsinyno;
    }

    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }

    @Column(order = 45, label = "（ＩＦｃ）通信先住所１（漢字）")
    private String ifcTsinadr1kj;

    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }

    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }

    @Column(order = 46, label = "（ＩＦｃ）通信先住所２（漢字）")
    private String ifcTsinadr2kj;

    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }

    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }

    @Column(order = 47, label = "（ＩＦｃ）通信先住所３（漢字）")
    private String ifcTsinadr3kj;

    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }

    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }

    @Column(order = 48, label = "（ＩＦｃ）通信先住所４（漢字）")
    private String ifcTsinadr4kj;

    public String getIfcTsinadr4kj() {
        return ifcTsinadr4kj;
    }

    public void setIfcTsinadr4kj(String pIfcTsinadr4kj) {
        ifcTsinadr4kj = pIfcTsinadr4kj;
    }

    @Column(order = 49, label = "（ＩＦｃ）代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 50, label = "（ＩＦｃ）代理店名（漢字）")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 51, label = "（ＩＦｃ）取扱コード")
    private Integer ifcTratkicd;

    public Integer getIfcTratkicd() {
        return ifcTratkicd;
    }

    public void setIfcTratkicd(Integer pIfcTratkicd) {
        ifcTratkicd = pIfcTratkicd;
    }

    @Column(order = 52, label = "（ＩＦｃ）帳票コード")
    private String ifcTyouhyoucd;

    public String getIfcTyouhyoucd() {
        return ifcTyouhyoucd;
    }

    public void setIfcTyouhyoucd(String pIfcTyouhyoucd) {
        ifcTyouhyoucd = pIfcTyouhyoucd;
    }

    @Column(order = 53, label = "（ＩＦｃ）帳票連絡先識別区分")
    private C_TyhyrenrakusikibetuKbn ifcTyhyrenrakusikibetukbn;

    public C_TyhyrenrakusikibetuKbn getIfcTyhyrenrakusikibetukbn() {
        return ifcTyhyrenrakusikibetukbn;
    }

    public void setIfcTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pIfcTyhyrenrakusikibetukbn) {
        ifcTyhyrenrakusikibetukbn = pIfcTyhyrenrakusikibetukbn;
    }

    @Column(order = 54, label = "（ＩＦｃ）エンド")
    private String ifcEnd;

    public String getIfcEnd() {
        return ifcEnd;
    }

    public void setIfcEnd(String pIfcEnd) {
        ifcEnd = pIfcEnd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
