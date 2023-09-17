package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）会計連動ファイルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKaikeirendouLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzKaikeirendouLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）伝票区切")
    private String ifcDenkugiri;

    public String getIfcDenkugiri() {
        return ifcDenkugiri;
    }

    public void setIfcDenkugiri(String pIfcDenkugiri) {
        ifcDenkugiri = pIfcDenkugiri;
    }

    @Column(order = 2, label = "（ＩＦｃ）伝票区分コード")
    private Integer ifcDenkbncd;

    public Integer getIfcDenkbncd() {
        return ifcDenkbncd;
    }

    public void setIfcDenkbncd(Integer pIfcDenkbncd) {
        ifcDenkbncd = pIfcDenkbncd;
    }

    @Column(order = 3, label = "（ＩＦｃ）用途区分")
    private String ifcYoutokbn;

    public String getIfcYoutokbn() {
        return ifcYoutokbn;
    }

    public void setIfcYoutokbn(String pIfcYoutokbn) {
        ifcYoutokbn = pIfcYoutokbn;
    }

    @Column(order = 4, label = "（ＩＦｃ）部門指定方法")
    private String ifcBumonsiteihou;

    public String getIfcBumonsiteihou() {
        return ifcBumonsiteihou;
    }

    public void setIfcBumonsiteihou(String pIfcBumonsiteihou) {
        ifcBumonsiteihou = pIfcBumonsiteihou;
    }

    @Column(order = 5, label = "（ＩＦｃ）伝票部門コード")
    private String ifcDenbumoncd;

    public String getIfcDenbumoncd() {
        return ifcDenbumoncd;
    }

    public void setIfcDenbumoncd(String pIfcDenbumoncd) {
        ifcDenbumoncd = pIfcDenbumoncd;
    }

    @Column(order = 6, label = "（ＩＦｃ）伝票日付")
    private String ifcDenymd;

    public String getIfcDenymd() {
        return ifcDenymd;
    }

    public void setIfcDenymd(String pIfcDenymd) {
        ifcDenymd = pIfcDenymd;
    }

    @Column(order = 7, label = "（ＩＦｃ）整理部分")
    private String ifcSeiribubun;

    public String getIfcSeiribubun() {
        return ifcSeiribubun;
    }

    public void setIfcSeiribubun(String pIfcSeiribubun) {
        ifcSeiribubun = pIfcSeiribubun;
    }

    @Column(order = 8, label = "（ＩＦｃ）振替伝票番号")
    private Integer ifcHuridenpyouno;

    public Integer getIfcHuridenpyouno() {
        return ifcHuridenpyouno;
    }

    public void setIfcHuridenpyouno(Integer pIfcHuridenpyouno) {
        ifcHuridenpyouno = pIfcHuridenpyouno;
    }

    @Column(order = 9, label = "（ＩＦｃ）部門コード（借方）")
    private Integer ifcBumoncdkari;

    public Integer getIfcBumoncdkari() {
        return ifcBumoncdkari;
    }

    public void setIfcBumoncdkari(Integer pIfcBumoncdkari) {
        ifcBumoncdkari = pIfcBumoncdkari;
    }

    @Column(order = 10, label = "（ＩＦｃ）勘定科目コード（借方）")
    private String ifcKanjyoukmkcdkari;

    public String getIfcKanjyoukmkcdkari() {
        return ifcKanjyoukmkcdkari;
    }

    public void setIfcKanjyoukmkcdkari(String pIfcKanjyoukmkcdkari) {
        ifcKanjyoukmkcdkari = pIfcKanjyoukmkcdkari;
    }

    @Column(order = 11, label = "（ＩＦｃ）補助科目コード（借方）")
    private String ifcHojokmkcdkari;

    public String getIfcHojokmkcdkari() {
        return ifcHojokmkcdkari;
    }

    public void setIfcHojokmkcdkari(String pIfcHojokmkcdkari) {
        ifcHojokmkcdkari = pIfcHojokmkcdkari;
    }

    @Column(order = 12, label = "（ＩＦｃ）税区分コード（借方）")
    private String ifcZeikbnkari;

    public String getIfcZeikbnkari() {
        return ifcZeikbnkari;
    }

    public void setIfcZeikbnkari(String pIfcZeikbnkari) {
        ifcZeikbnkari = pIfcZeikbnkari;
    }

    @Column(order = 13, label = "（ＩＦｃ）税率区分コード（借方）")
    private String ifcZeiritukbncdkari;

    public String getIfcZeiritukbncdkari() {
        return ifcZeiritukbncdkari;
    }

    public void setIfcZeiritukbncdkari(String pIfcZeiritukbncdkari) {
        ifcZeiritukbncdkari = pIfcZeiritukbncdkari;
    }

    @Column(order = 14, label = "（ＩＦｃ）事業区分コード（借方）")
    private String ifcJigyoukbncdkari;

    public String getIfcJigyoukbncdkari() {
        return ifcJigyoukbncdkari;
    }

    public void setIfcJigyoukbncdkari(String pIfcJigyoukbncdkari) {
        ifcJigyoukbncdkari = pIfcJigyoukbncdkari;
    }

    @Column(order = 15, label = "（ＩＦｃ）消費税自動計算（借方）")
    private String ifcSyouhizeijdkeisankari;

    public String getIfcSyouhizeijdkeisankari() {
        return ifcSyouhizeijdkeisankari;
    }

    public void setIfcSyouhizeijdkeisankari(String pIfcSyouhizeijdkeisankari) {
        ifcSyouhizeijdkeisankari = pIfcSyouhizeijdkeisankari;
    }

    @Column(order = 16, label = "（ＩＦｃ）端数処理（借方）")
    private String ifcHasuusyorikari;

    public String getIfcHasuusyorikari() {
        return ifcHasuusyorikari;
    }

    public void setIfcHasuusyorikari(String pIfcHasuusyorikari) {
        ifcHasuusyorikari = pIfcHasuusyorikari;
    }

    @Column(order = 17, label = "（ＩＦｃ）取引先コード（借方）")
    private String ifcTorihikisakicdkari;

    public String getIfcTorihikisakicdkari() {
        return ifcTorihikisakicdkari;
    }

    public void setIfcTorihikisakicdkari(String pIfcTorihikisakicdkari) {
        ifcTorihikisakicdkari = pIfcTorihikisakicdkari;
    }

    @Column(order = 18, label = "（ＩＦｃ）セグメント１コード（借方）")
    private String ifcSeg1cdkari;

    public String getIfcSeg1cdkari() {
        return ifcSeg1cdkari;
    }

    public void setIfcSeg1cdkari(String pIfcSeg1cdkari) {
        ifcSeg1cdkari = pIfcSeg1cdkari;
    }

    @Column(order = 19, label = "（ＩＦｃ）セグメント２コード（借方）")
    private String ifcSeg2cdkari;

    public String getIfcSeg2cdkari() {
        return ifcSeg2cdkari;
    }

    public void setIfcSeg2cdkari(String pIfcSeg2cdkari) {
        ifcSeg2cdkari = pIfcSeg2cdkari;
    }

    @Column(order = 20, label = "（ＩＦｃ）本体金額（借方）")
    private String ifcHontaigkkari;

    public String getIfcHontaigkkari() {
        return ifcHontaigkkari;
    }

    public void setIfcHontaigkkari(String pIfcHontaigkkari) {
        ifcHontaigkkari = pIfcHontaigkkari;
    }

    @Column(order = 21, label = "（ＩＦｃ）消費税額（借方）")
    private String ifcSyouhizeigkkari;

    public String getIfcSyouhizeigkkari() {
        return ifcSyouhizeigkkari;
    }

    public void setIfcSyouhizeigkkari(String pIfcSyouhizeigkkari) {
        ifcSyouhizeigkkari = pIfcSyouhizeigkkari;
    }

    @Column(order = 22, label = "（ＩＦｃ）部門コード（貸方）")
    private Integer ifcBumoncdkasi;

    public Integer getIfcBumoncdkasi() {
        return ifcBumoncdkasi;
    }

    public void setIfcBumoncdkasi(Integer pIfcBumoncdkasi) {
        ifcBumoncdkasi = pIfcBumoncdkasi;
    }

    @Column(order = 23, label = "（ＩＦｃ）勘定科目コード（貸方）")
    private String ifcKanjyoukmkcdkasi;

    public String getIfcKanjyoukmkcdkasi() {
        return ifcKanjyoukmkcdkasi;
    }

    public void setIfcKanjyoukmkcdkasi(String pIfcKanjyoukmkcdkasi) {
        ifcKanjyoukmkcdkasi = pIfcKanjyoukmkcdkasi;
    }

    @Column(order = 24, label = "（ＩＦｃ）補助科目コード（貸方）")
    private String ifcHojokmkcdkasi;

    public String getIfcHojokmkcdkasi() {
        return ifcHojokmkcdkasi;
    }

    public void setIfcHojokmkcdkasi(String pIfcHojokmkcdkasi) {
        ifcHojokmkcdkasi = pIfcHojokmkcdkasi;
    }

    @Column(order = 25, label = "（ＩＦｃ）税区分コード（貸方）")
    private String ifcZeikbnkasi;

    public String getIfcZeikbnkasi() {
        return ifcZeikbnkasi;
    }

    public void setIfcZeikbnkasi(String pIfcZeikbnkasi) {
        ifcZeikbnkasi = pIfcZeikbnkasi;
    }

    @Column(order = 26, label = "（ＩＦｃ）税率区分コード（貸方）")
    private String ifcZeiritukbncdkasi;

    public String getIfcZeiritukbncdkasi() {
        return ifcZeiritukbncdkasi;
    }

    public void setIfcZeiritukbncdkasi(String pIfcZeiritukbncdkasi) {
        ifcZeiritukbncdkasi = pIfcZeiritukbncdkasi;
    }

    @Column(order = 27, label = "（ＩＦｃ）事業区分コード（貸方）")
    private String ifcJigyoukbncdkasi;

    public String getIfcJigyoukbncdkasi() {
        return ifcJigyoukbncdkasi;
    }

    public void setIfcJigyoukbncdkasi(String pIfcJigyoukbncdkasi) {
        ifcJigyoukbncdkasi = pIfcJigyoukbncdkasi;
    }

    @Column(order = 28, label = "（ＩＦｃ）消費税自動計算（貸方）")
    private String ifcSyouhizeijdkeisankasi;

    public String getIfcSyouhizeijdkeisankasi() {
        return ifcSyouhizeijdkeisankasi;
    }

    public void setIfcSyouhizeijdkeisankasi(String pIfcSyouhizeijdkeisankasi) {
        ifcSyouhizeijdkeisankasi = pIfcSyouhizeijdkeisankasi;
    }

    @Column(order = 29, label = "（ＩＦｃ）端数処理（貸方）")
    private String ifcHasuusyorikasi;

    public String getIfcHasuusyorikasi() {
        return ifcHasuusyorikasi;
    }

    public void setIfcHasuusyorikasi(String pIfcHasuusyorikasi) {
        ifcHasuusyorikasi = pIfcHasuusyorikasi;
    }

    @Column(order = 30, label = "（ＩＦｃ）取引先コード（貸方）")
    private String ifcTorihikisakicdkasi;

    public String getIfcTorihikisakicdkasi() {
        return ifcTorihikisakicdkasi;
    }

    public void setIfcTorihikisakicdkasi(String pIfcTorihikisakicdkasi) {
        ifcTorihikisakicdkasi = pIfcTorihikisakicdkasi;
    }

    @Column(order = 31, label = "（ＩＦｃ）セグメント１コード（貸方）")
    private String ifcSeg1cdkasi;

    public String getIfcSeg1cdkasi() {
        return ifcSeg1cdkasi;
    }

    public void setIfcSeg1cdkasi(String pIfcSeg1cdkasi) {
        ifcSeg1cdkasi = pIfcSeg1cdkasi;
    }

    @Column(order = 32, label = "（ＩＦｃ）セグメント２コード（貸方）")
    private String ifcSeg2cdkasi;

    public String getIfcSeg2cdkasi() {
        return ifcSeg2cdkasi;
    }

    public void setIfcSeg2cdkasi(String pIfcSeg2cdkasi) {
        ifcSeg2cdkasi = pIfcSeg2cdkasi;
    }

    @Column(order = 33, label = "（ＩＦｃ）本体金額（貸方）")
    private String ifcHontaigkkasi;

    public String getIfcHontaigkkasi() {
        return ifcHontaigkkasi;
    }

    public void setIfcHontaigkkasi(String pIfcHontaigkkasi) {
        ifcHontaigkkasi = pIfcHontaigkkasi;
    }

    @Column(order = 34, label = "（ＩＦｃ）消費税額（貸方）")
    private String ifcSyouhizeigkkasi;

    public String getIfcSyouhizeigkkasi() {
        return ifcSyouhizeigkkasi;
    }

    public void setIfcSyouhizeigkkasi(String pIfcSyouhizeigkkasi) {
        ifcSyouhizeigkkasi = pIfcSyouhizeigkkasi;
    }

    @Column(order = 35, label = "（ＩＦｃ）摘要内容")
    private String ifcTekiyounaiyou;

    public String getIfcTekiyounaiyou() {
        return ifcTekiyounaiyou;
    }

    public void setIfcTekiyounaiyou(String pIfcTekiyounaiyou) {
        ifcTekiyounaiyou = pIfcTekiyounaiyou;
    }

    @Column(order = 36, label = "（ＩＦｃ）付箋色")
    private String ifcHusencolor;

    public String getIfcHusencolor() {
        return ifcHusencolor;
    }

    public void setIfcHusencolor(String pIfcHusencolor) {
        ifcHusencolor = pIfcHusencolor;
    }

    @Column(order = 37, label = "（ＩＦｃ）付箋文字")
    private String ifcHusenmoji;

    public String getIfcHusenmoji() {
        return ifcHusenmoji;
    }

    public void setIfcHusenmoji(String pIfcHusenmoji) {
        ifcHusenmoji = pIfcHusenmoji;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
