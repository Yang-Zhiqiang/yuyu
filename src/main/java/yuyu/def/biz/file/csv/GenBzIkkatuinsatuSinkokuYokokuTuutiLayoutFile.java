package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Kktyhysksitisy;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;

/**
 * （共通）専用帳票一括印刷送信ファイル（申告予告通知レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzIkkatuinsatuSinkokuYokokuTuutiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzIkkatuinsatuSinkokuYokokuTuutiLayoutFile() {
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

    @Column(order = 6, label = "（ＩＦｃ）帳票作成日（印刷用）")
    private BizDate ifcTyouhyouprtymd;

    public BizDate getIfcTyouhyouprtymd() {
        return ifcTyouhyouprtymd;
    }

    public void setIfcTyouhyouprtymd(BizDate pIfcTyouhyouprtymd) {
        ifcTyouhyouprtymd = pIfcTyouhyouprtymd;
    }

    @Column(order = 7, label = "（ＩＦｃ）年度")
    private String ifcNendo;

    public String getIfcNendo() {
        return ifcNendo;
    }

    public void setIfcNendo(String pIfcNendo) {
        ifcNendo = pIfcNendo;
    }

    @Column(order = 8, label = "（ＩＦｃ）適用制度区分")
    private C_TekiyouseidoKbn ifcTekiyouseidokbn;

    public C_TekiyouseidoKbn getIfcTekiyouseidokbn() {
        return ifcTekiyouseidokbn;
    }

    public void setIfcTekiyouseidokbn(C_TekiyouseidoKbn pIfcTekiyouseidokbn) {
        ifcTekiyouseidokbn = pIfcTekiyouseidokbn;
    }

    @Column(order = 9, label = "（ＩＦｃ）契約管理帳票作成対象区分")
    private C_Kktyhysksitisy ifcKktyhysksitisykbn;

    public C_Kktyhysksitisy getIfcKktyhysksitisykbn() {
        return ifcKktyhysksitisykbn;
    }

    public void setIfcKktyhysksitisykbn(C_Kktyhysksitisy pIfcKktyhysksitisykbn) {
        ifcKktyhysksitisykbn = pIfcKktyhysksitisykbn;
    }

    @Column(order = 10, label = "（ＩＦｃ）保険料充当開始予定年月")
    private String ifcPjyutoustartyoteiym;

    public String getIfcPjyutoustartyoteiym() {
        return ifcPjyutoustartyoteiym;
    }

    public void setIfcPjyutoustartyoteiym(String pIfcPjyutoustartyoteiym) {
        ifcPjyutoustartyoteiym = pIfcPjyutoustartyoteiym;
    }

    @Column(order = 11, label = "（ＩＦｃ）保険料充当終了予定年月")
    private String ifcPjyutouendyoteiym;

    public String getIfcPjyutouendyoteiym() {
        return ifcPjyutouendyoteiym;
    }

    public void setIfcPjyutouendyoteiym(String pIfcPjyutouendyoteiym) {
        ifcPjyutouendyoteiym = pIfcPjyutouendyoteiym;
    }

    @Column(order = 12, label = "（ＩＦｃ）保険料充当予定期間月数")
    private Integer ifcPjyutouyoteikkntukisuu;

    public Integer getIfcPjyutouyoteikkntukisuu() {
        return ifcPjyutouyoteikkntukisuu;
    }

    public void setIfcPjyutouyoteikkntukisuu(Integer pIfcPjyutouyoteikkntukisuu) {
        ifcPjyutouyoteikkntukisuu = pIfcPjyutouyoteikkntukisuu;
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

    @Column(order = 20, label = "（ＩＦｃ）旧制度一般予告保険料")
    private String ifcOldippanykkp;

    public String getIfcOldippanykkp() {
        return ifcOldippanykkp;
    }

    public void setIfcOldippanykkp(String pIfcOldippanykkp) {
        ifcOldippanykkp = pIfcOldippanykkp;
    }

    @Column(order = 21, label = "（ＩＦｃ）旧制度一般予告配当金")
    private String ifcOldippanykkhaitoukin;

    public String getIfcOldippanykkhaitoukin() {
        return ifcOldippanykkhaitoukin;
    }

    public void setIfcOldippanykkhaitoukin(String pIfcOldippanykkhaitoukin) {
        ifcOldippanykkhaitoukin = pIfcOldippanykkhaitoukin;
    }

    @Column(order = 22, label = "（ＩＦｃ）旧制度一般予告証明額")
    private String ifcOldippanykksyoumeigk;

    public String getIfcOldippanykksyoumeigk() {
        return ifcOldippanykksyoumeigk;
    }

    public void setIfcOldippanykksyoumeigk(String pIfcOldippanykksyoumeigk) {
        ifcOldippanykksyoumeigk = pIfcOldippanykksyoumeigk;
    }

    @Column(order = 23, label = "（ＩＦｃ）新制度一般予告保険料")
    private String ifcNewippanykkp;

    public String getIfcNewippanykkp() {
        return ifcNewippanykkp;
    }

    public void setIfcNewippanykkp(String pIfcNewippanykkp) {
        ifcNewippanykkp = pIfcNewippanykkp;
    }

    @Column(order = 24, label = "（ＩＦｃ）新制度一般予告配当金")
    private String ifcNewippanykkhaitoukin;

    public String getIfcNewippanykkhaitoukin() {
        return ifcNewippanykkhaitoukin;
    }

    public void setIfcNewippanykkhaitoukin(String pIfcNewippanykkhaitoukin) {
        ifcNewippanykkhaitoukin = pIfcNewippanykkhaitoukin;
    }

    @Column(order = 25, label = "（ＩＦｃ）新制度一般予告証明額")
    private String ifcNewippanykksyoumeigk;

    public String getIfcNewippanykksyoumeigk() {
        return ifcNewippanykksyoumeigk;
    }

    public void setIfcNewippanykksyoumeigk(String pIfcNewippanykksyoumeigk) {
        ifcNewippanykksyoumeigk = pIfcNewippanykksyoumeigk;
    }

    @Column(order = 26, label = "（ＩＦｃ）新制度介護医療予告保険料")
    private String ifcNewiryouykkp;

    public String getIfcNewiryouykkp() {
        return ifcNewiryouykkp;
    }

    public void setIfcNewiryouykkp(String pIfcNewiryouykkp) {
        ifcNewiryouykkp = pIfcNewiryouykkp;
    }

    @Column(order = 27, label = "（ＩＦｃ）新制度介護医療予告配当金")
    private String ifcNewiryouykkhaitoukin;

    public String getIfcNewiryouykkhaitoukin() {
        return ifcNewiryouykkhaitoukin;
    }

    public void setIfcNewiryouykkhaitoukin(String pIfcNewiryouykkhaitoukin) {
        ifcNewiryouykkhaitoukin = pIfcNewiryouykkhaitoukin;
    }

    @Column(order = 28, label = "（ＩＦｃ）新制度介護医療予告証明額")
    private String ifcNewiryouykksyoumeigk;

    public String getIfcNewiryouykksyoumeigk() {
        return ifcNewiryouykksyoumeigk;
    }

    public void setIfcNewiryouykksyoumeigk(String pIfcNewiryouykksyoumeigk) {
        ifcNewiryouykksyoumeigk = pIfcNewiryouykksyoumeigk;
    }

    @Column(order = 29, label = "（ＩＦｃ）新制度年金予告保険料")
    private String ifcNewnenkinykkp;

    public String getIfcNewnenkinykkp() {
        return ifcNewnenkinykkp;
    }

    public void setIfcNewnenkinykkp(String pIfcNewnenkinykkp) {
        ifcNewnenkinykkp = pIfcNewnenkinykkp;
    }

    @Column(order = 30, label = "（ＩＦｃ）新制度年金予告配当金")
    private String ifcNewnenkinykkhaitoukin;

    public String getIfcNewnenkinykkhaitoukin() {
        return ifcNewnenkinykkhaitoukin;
    }

    public void setIfcNewnenkinykkhaitoukin(String pIfcNewnenkinykkhaitoukin) {
        ifcNewnenkinykkhaitoukin = pIfcNewnenkinykkhaitoukin;
    }

    @Column(order = 31, label = "（ＩＦｃ）新制度年金予告証明額")
    private String ifcNewnenkinykksyoumeigk;

    public String getIfcNewnenkinykksyoumeigk() {
        return ifcNewnenkinykksyoumeigk;
    }

    public void setIfcNewnenkinykksyoumeigk(String pIfcNewnenkinykksyoumeigk) {
        ifcNewnenkinykksyoumeigk = pIfcNewnenkinykksyoumeigk;
    }

    @Column(order = 32, label = "（ＩＦｃ）通信先郵便番号")
    private String ifcTsinyno;

    public String getIfcTsinyno() {
        return ifcTsinyno;
    }

    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }

    @Column(order = 33, label = "（ＩＦｃ）通信先住所１（漢字）")
    private String ifcTsinadr1kj;

    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }

    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }

    @Column(order = 34, label = "（ＩＦｃ）通信先住所２（漢字）")
    private String ifcTsinadr2kj;

    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }

    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }

    @Column(order = 35, label = "（ＩＦｃ）通信先住所３（漢字）")
    private String ifcTsinadr3kj;

    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }

    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }

    @Column(order = 36, label = "（ＩＦｃ）通信先住所４（漢字）")
    private String ifcTsinadr4kj;

    public String getIfcTsinadr4kj() {
        return ifcTsinadr4kj;
    }

    public void setIfcTsinadr4kj(String pIfcTsinadr4kj) {
        ifcTsinadr4kj = pIfcTsinadr4kj;
    }

    @Column(order = 37, label = "（ＩＦｃ）代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 38, label = "（ＩＦｃ）代理店名（漢字）")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 39, label = "（ＩＦｃ）取扱コード")
    private Integer ifcTratkicd;

    public Integer getIfcTratkicd() {
        return ifcTratkicd;
    }

    public void setIfcTratkicd(Integer pIfcTratkicd) {
        ifcTratkicd = pIfcTratkicd;
    }

    @Column(order = 40, label = "（ＩＦｃ）帳票コード")
    private String ifcTyouhyoucd;

    public String getIfcTyouhyoucd() {
        return ifcTyouhyoucd;
    }

    public void setIfcTyouhyoucd(String pIfcTyouhyoucd) {
        ifcTyouhyoucd = pIfcTyouhyoucd;
    }

    @Column(order = 41, label = "（ＩＦｃ）帳票連絡先識別区分")
    private C_TyhyrenrakusikibetuKbn ifcTyhyrenrakusikibetukbn;

    public C_TyhyrenrakusikibetuKbn getIfcTyhyrenrakusikibetukbn() {
        return ifcTyhyrenrakusikibetukbn;
    }

    public void setIfcTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pIfcTyhyrenrakusikibetukbn) {
        ifcTyhyrenrakusikibetukbn = pIfcTyhyrenrakusikibetukbn;
    }

    @Column(order = 42, label = "（ＩＦｃ）エンド")
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
