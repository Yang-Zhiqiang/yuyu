package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_SntkinfoKbn;

/**
 * 選択情報Ｆ索引結果Beanクラスです。<br />
 */
public class BzSentakuInfoFSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sntkinfono;

    private C_KankeisyaKbn sntkinfokankeisyakbn;

    private String sntkinfofkojinkbn;

    private C_SntkinfoKbn sntkinfokbn;

    private BizDate sntkinfosakuseiymd;

    private C_BlnktkumuKbn mrumukbn;

    private C_BlnktkumuKbn decumukbn;

    private C_BlnktkumuKbn infokoukanumukbn;

    private C_BlnktkumuKbn nyuuinkyhkshrumukbn;

    private C_BlnktkumuKbn syujyutukyhkshrumukbn;

    private C_BlnktkumuKbn syougaikyhkshrumukbn;

    private C_BlnktkumuKbn koudosyougaiumukbn;

    private C_BlnktkumuKbn pmenumukbn;

    private C_BlnktkumuKbn torikaijoumukbn;

    private C_BlnktkumuKbn soukikeakyhkshrumukbn;

    private C_BlnktkumuKbn sonotakyhkshrumukbn;

    private C_BlnktkumuKbn kghsjjtkyhkshrumukbn;

    private C_BlnktkumuKbn huho2mrumukbn;

    private C_BlnktkumuKbn huho2decumukbn;

    private C_BlnktkumuKbn huho2kdumukbn;

    private C_BlnktkumuKbn huho2torikaijoumukbn;

    public BzSentakuInfoFSakuinKekkaBean() {
        super();
    }

    public String getSntkinfono() {
        return sntkinfono;
    }

    public void setSntkinfono(String pSntkinfono) {
        sntkinfono = pSntkinfono;
    }

    public C_KankeisyaKbn getSntkinfokankeisyakbn() {
        return sntkinfokankeisyakbn;
    }

    public void setSntkinfokankeisyakbn(C_KankeisyaKbn pSntkinfokankeisyakbn) {
        sntkinfokankeisyakbn = pSntkinfokankeisyakbn;
    }

    public String getSntkinfofkojinkbn() {
        return sntkinfofkojinkbn;
    }

    public void setSntkinfofkojinkbn(String pSntkinfofkojinkbn) {
        sntkinfofkojinkbn = pSntkinfofkojinkbn;
    }

    public C_SntkinfoKbn getSntkinfokbn() {
        return sntkinfokbn;
    }

    public void setSntkinfokbn(C_SntkinfoKbn pSntkinfokbn) {
        sntkinfokbn = pSntkinfokbn;
    }

    public BizDate getSntkinfosakuseiymd() {
        return sntkinfosakuseiymd;
    }

    public void setSntkinfosakuseiymd(BizDate pSntkinfosakuseiymd) {
        sntkinfosakuseiymd = pSntkinfosakuseiymd;
    }

    public C_BlnktkumuKbn getMrumukbn() {
        return mrumukbn;
    }

    public void setMrumukbn(C_BlnktkumuKbn pMrumukbn) {
        mrumukbn = pMrumukbn;
    }

    public C_BlnktkumuKbn getDecumukbn() {
        return decumukbn;
    }

    public void setDecumukbn(C_BlnktkumuKbn pDecumukbn) {
        decumukbn = pDecumukbn;
    }

    public C_BlnktkumuKbn getInfokoukanumukbn() {
        return infokoukanumukbn;
    }

    public void setInfokoukanumukbn(C_BlnktkumuKbn pInfokoukanumukbn) {
        infokoukanumukbn = pInfokoukanumukbn;
    }

    public C_BlnktkumuKbn getNyuuinkyhkshrumukbn() {
        return nyuuinkyhkshrumukbn;
    }

    public void setNyuuinkyhkshrumukbn(C_BlnktkumuKbn pNyuuinkyhkshrumukbn) {
        nyuuinkyhkshrumukbn = pNyuuinkyhkshrumukbn;
    }

    public C_BlnktkumuKbn getSyujyutukyhkshrumukbn() {
        return syujyutukyhkshrumukbn;
    }

    public void setSyujyutukyhkshrumukbn(C_BlnktkumuKbn pSyujyutukyhkshrumukbn) {
        syujyutukyhkshrumukbn = pSyujyutukyhkshrumukbn;
    }

    public C_BlnktkumuKbn getSyougaikyhkshrumukbn() {
        return syougaikyhkshrumukbn;
    }

    public void setSyougaikyhkshrumukbn(C_BlnktkumuKbn pSyougaikyhkshrumukbn) {
        syougaikyhkshrumukbn = pSyougaikyhkshrumukbn;
    }

    public C_BlnktkumuKbn getKoudosyougaiumukbn() {
        return koudosyougaiumukbn;
    }

    public void setKoudosyougaiumukbn(C_BlnktkumuKbn pKoudosyougaiumukbn) {
        koudosyougaiumukbn = pKoudosyougaiumukbn;
    }

    public C_BlnktkumuKbn getPmenumukbn() {
        return pmenumukbn;
    }

    public void setPmenumukbn(C_BlnktkumuKbn pPmenumukbn) {
        pmenumukbn = pPmenumukbn;
    }

    public C_BlnktkumuKbn getTorikaijoumukbn() {
        return torikaijoumukbn;
    }

    public void setTorikaijoumukbn(C_BlnktkumuKbn pTorikaijoumukbn) {
        torikaijoumukbn = pTorikaijoumukbn;
    }

    public C_BlnktkumuKbn getSoukikeakyhkshrumukbn() {
        return soukikeakyhkshrumukbn;
    }

    public void setSoukikeakyhkshrumukbn(C_BlnktkumuKbn pSoukikeakyhkshrumukbn) {
        soukikeakyhkshrumukbn = pSoukikeakyhkshrumukbn;
    }

    public C_BlnktkumuKbn getSonotakyhkshrumukbn() {
        return sonotakyhkshrumukbn;
    }

    public void setSonotakyhkshrumukbn(C_BlnktkumuKbn pSonotakyhkshrumukbn) {
        sonotakyhkshrumukbn = pSonotakyhkshrumukbn;
    }

    public C_BlnktkumuKbn getKghsjjtkyhkshrumukbn() {
        return kghsjjtkyhkshrumukbn;
    }

    public void setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn pKghsjjtkyhkshrumukbn) {
        kghsjjtkyhkshrumukbn = pKghsjjtkyhkshrumukbn;
    }

    public C_BlnktkumuKbn getHuho2mrumukbn() {
        return huho2mrumukbn;
    }

    public void setHuho2mrumukbn(C_BlnktkumuKbn pHuho2mrumukbn) {
        huho2mrumukbn = pHuho2mrumukbn;
    }

    public C_BlnktkumuKbn getHuho2decumukbn() {
        return huho2decumukbn;
    }

    public void setHuho2decumukbn(C_BlnktkumuKbn pHuho2decumukbn) {
        huho2decumukbn = pHuho2decumukbn;
    }

    public C_BlnktkumuKbn getHuho2kdumukbn() {
        return huho2kdumukbn;
    }

    public void setHuho2kdumukbn(C_BlnktkumuKbn pHuho2kdumukbn) {
        huho2kdumukbn = pHuho2kdumukbn;
    }

    public C_BlnktkumuKbn getHuho2torikaijoumukbn() {
        return huho2torikaijoumukbn;
    }

    public void setHuho2torikaijoumukbn(C_BlnktkumuKbn pHuho2torikaijoumukbn) {
        huho2torikaijoumukbn = pHuho2torikaijoumukbn;
    }

}
