package yuyu.common.biz.bzdairiten;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DaisinHiDaisinKbn;
import yuyu.def.classification.C_Diritenbunruicd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.def.classification.C_TykatukaiyouDrtenHyouji;

/**
 * 業務共通 代理店 代理店情報出力Beanクラス
 */
public class BzGetAgInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_DiritenjyouhouKbn diritenJyouhouKbn;

    private String drtenCd;

    private String drtenNm;

    private String kanjiDairitenNm;

    private BizDate itakukeiyakuYmd;

    private BizDate itakukeiyakuKaiyakuYmd;

    private BizDate dairitenTourokuYmd;

    private C_DaisinHiDaisinKbn daisinHidaisinKbn;

    private String drtKanrisosikiCd1;

    private String drtKanrisosikiCd2;

    private String drtKanrisosikiCd3;

    private String keisyousakiDrtenCd;

    private String ksymtDrtenCd;

    private String dairitenTelNo;

    private String dairitenFaxNo;

    private String oyadrtenCd;

    private String drtentrkno;

    private BizDate dairitenKouryokuKaisiYmd;

    private BizDate dairitenKouryokuSyuuryouYmd;

    private String kinyuuCd;

    private String kinyuuSitenCd;

    private String drtenJimCd;

    private String daiBosyuuCd;

    private C_MdhnSchemeDrtenHyouji mdhnSchemeDrtenHyouji;

    private C_TykatukaiyouDrtenHyouji tykatukaiyouDrtenHyouji;

    private C_TkrtkKinyuuknHyouji tkrtkKinyuuknHyouji;

    private C_KydsskKinyuuknHyouji kydsskKinyuuknHyouji;

    private C_KydBosyuuDairitenHyouji kydBosyuuDairitenHyouji;

    private String yuuseijimusyoCd;

    private String toukatuDairitenCd;

    private List<TesuuryouInfoBean> tesuuryouInfoBeanLst;

    private int hnsituHykrankTougetu;

    private int hnsituHykrankYokugetu;

    private String kanjiHoujinSyougou;

    private C_Diritenbunruicd diritenBunruiCd;

    private C_Channelcd channelCd;

    private C_DrtenChannelSyurui drtenChannelSyurui;

    public C_DiritenjyouhouKbn getDiritenJyouhouKbn() {
        return diritenJyouhouKbn;
    }

    public void setDiritenJyouhouKbn(C_DiritenjyouhouKbn pDiritenJyouhouKbn) {
        diritenJyouhouKbn = pDiritenJyouhouKbn;
    }

    public String getDrtenCd() {
        return drtenCd;
    }

    public void setDrtenCd(String pDrtenCd) {
        drtenCd = pDrtenCd;
    }

    public String getDrtenNm() {
        return drtenNm;
    }

    public void setDrtenNm(String pDrtenNm) {
        drtenNm = pDrtenNm;
    }

    public String getKanjiDairitenNm() {
        return kanjiDairitenNm;
    }

    public void setKanjiDairitenNm(String pKanjiDairitenNm) {
        kanjiDairitenNm = pKanjiDairitenNm;
    }

    public BizDate getItakukeiyakuYmd() {
        return itakukeiyakuYmd;
    }

    public void setItakukeiyakuYmd(BizDate pItakukeiyakuYmd) {
        itakukeiyakuYmd = pItakukeiyakuYmd;
    }

    public BizDate getItakukeiyakuKaiyakuYmd() {
        return itakukeiyakuKaiyakuYmd;
    }

    public void setItakukeiyakuKaiyakuYmd(BizDate pItakukeiyakuKaiyakuYmd) {
        itakukeiyakuKaiyakuYmd = pItakukeiyakuKaiyakuYmd;
    }

    public BizDate getDairitenTourokuYmd() {
        return dairitenTourokuYmd;
    }

    public void setDairitenTourokuYmd(BizDate pDairitenTourokuYmd) {
        dairitenTourokuYmd = pDairitenTourokuYmd;
    }

    public C_DaisinHiDaisinKbn getDaisinHidaisinKbn() {
        return daisinHidaisinKbn;
    }

    public void setDaisinHidaisinKbn(C_DaisinHiDaisinKbn pDaisinHidaisinKbn) {
        daisinHidaisinKbn = pDaisinHidaisinKbn;
    }

    public String getDrtKanrisosikiCd1() {
        return drtKanrisosikiCd1;
    }

    public void setDrtKanrisosikiCd1(String pDrtKanrisosikiCd1) {
        drtKanrisosikiCd1 = pDrtKanrisosikiCd1;
    }

    public String getDrtKanrisosikiCd2() {
        return drtKanrisosikiCd2;
    }

    public void setDrtKanrisosikiCd2(String pDrtKanrisosikiCd2) {
        drtKanrisosikiCd2 = pDrtKanrisosikiCd2;
    }

    public String getDrtKanrisosikiCd3() {
        return drtKanrisosikiCd3;
    }

    public void setDrtKanrisosikiCd3(String pDrtKanrisosikiCd3) {
        drtKanrisosikiCd3 = pDrtKanrisosikiCd3;
    }

    public String getKeisyousakiDrtenCd() {
        return keisyousakiDrtenCd;
    }

    public void setKeisyousakiDrtenCd(String pKeisyousakiDrtenCd) {
        keisyousakiDrtenCd = pKeisyousakiDrtenCd;
    }

    public String getKsymtDrtenCd() {
        return ksymtDrtenCd;
    }

    public void setKsymtDrtenCd(String pKsymtDrtenCd) {
        ksymtDrtenCd = pKsymtDrtenCd;
    }

    public String getDairitenTelNo() {
        return dairitenTelNo;
    }

    public void setDairitenTelNo(String pDairitenTelNo) {
        dairitenTelNo = pDairitenTelNo;
    }

    public String getDairitenFaxNo() {
        return dairitenFaxNo;
    }

    public void setDairitenFaxNo(String pDairitenFaxNo) {
        dairitenFaxNo = pDairitenFaxNo;
    }

    public String getOyadrtenCd() {
        return oyadrtenCd;
    }

    public void setOyadrtenCd(String pOyadrtenCd) {
        oyadrtenCd = pOyadrtenCd;
    }

    public String getDrtentrkno() {
        return drtentrkno;
    }

    public void setDrtentrkno(String pDrtentrkno) {
        this.drtentrkno = pDrtentrkno;
    }

    public BizDate getDairitenKouryokuKaisiYmd() {
        return dairitenKouryokuKaisiYmd;
    }

    public void setDairitenKouryokuKaisiYmd(BizDate pDairitenKouryokuKaisiYmd) {
        dairitenKouryokuKaisiYmd = pDairitenKouryokuKaisiYmd;
    }

    public BizDate getDairitenKouryokuSyuuryouYmd() {
        return dairitenKouryokuSyuuryouYmd;
    }

    public void setDairitenKouryokuSyuuryouYmd(BizDate pDairitenKouryokuSyuuryouYmd) {
        dairitenKouryokuSyuuryouYmd = pDairitenKouryokuSyuuryouYmd;
    }

    public String getKinyuuCd() {
        return kinyuuCd;
    }

    public void setKinyuuCd(String pKinyuuCd) {
        kinyuuCd = pKinyuuCd;
    }

    public String getKinyuuSitenCd() {
        return kinyuuSitenCd;
    }

    public void setKinyuuSitenCd(String pKinyuuSitenCd) {
        kinyuuSitenCd = pKinyuuSitenCd;
    }

    public String getDrtenJimCd() {
        return drtenJimCd;
    }

    public void setDrtenJimCd(String pDrtenJimCd) {
        drtenJimCd = pDrtenJimCd;
    }

    public String getDaiBosyuuCd() {
        return daiBosyuuCd;
    }

    public void setDaiBosyuuCd(String pDaiBosyuuCd) {
        daiBosyuuCd = pDaiBosyuuCd;
    }

    public C_MdhnSchemeDrtenHyouji getMdhnSchemeDrtenHyouji() {
        return mdhnSchemeDrtenHyouji;
    }

    public void setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji pMdhnSchemeDrtenHyouji) {
        this.mdhnSchemeDrtenHyouji = pMdhnSchemeDrtenHyouji;
    }

    public C_TykatukaiyouDrtenHyouji getTykatukaiyouDrtenHyouji() {
        return tykatukaiyouDrtenHyouji;
    }

    public void setTykatukaiyouDrtenHyouji(C_TykatukaiyouDrtenHyouji pTykatukaiyouDrtenHyouji) {
        this.tykatukaiyouDrtenHyouji = pTykatukaiyouDrtenHyouji;
    }

    public C_TkrtkKinyuuknHyouji getTkrtkKinyuuknHyouji() {
        return tkrtkKinyuuknHyouji;
    }

    public void setTkrtkKinyuuknHyouji(C_TkrtkKinyuuknHyouji pTkrtkKinyuuknHyouji) {
        tkrtkKinyuuknHyouji = pTkrtkKinyuuknHyouji;
    }

    public C_KydsskKinyuuknHyouji getKydsskKinyuuknHyouji() {
        return kydsskKinyuuknHyouji;
    }

    public void setKydsskKinyuuknHyouji(C_KydsskKinyuuknHyouji pKydsskKinyuuknHyouji) {
        kydsskKinyuuknHyouji = pKydsskKinyuuknHyouji;
    }

    public C_KydBosyuuDairitenHyouji getKydBosyuuDairitenHyouji() {
        return kydBosyuuDairitenHyouji;
    }

    public void setKydBosyuuDairitenHyouji(C_KydBosyuuDairitenHyouji pKydBosyuuDairitenHyouji) {
        kydBosyuuDairitenHyouji = pKydBosyuuDairitenHyouji;
    }

    public String getYuuseijimusyoCd() {
        return yuuseijimusyoCd;
    }

    public void setYuuseijimusyoCd(String pYuuseijimusyoCd) {
        yuuseijimusyoCd = pYuuseijimusyoCd;
    }

    public String getToukatuDairitenCd() {
        return toukatuDairitenCd;
    }

    public void setToukatuDairitenCd(String pToukatuDairitenCd) {
        toukatuDairitenCd = pToukatuDairitenCd;
    }

    public List<TesuuryouInfoBean> getTesuuryouInfoBeanLst() {
        return tesuuryouInfoBeanLst;
    }

    public void setTesuuryouInfoBeanLst(List<TesuuryouInfoBean> pTesuuryouInfoBeanLst) {
        this.tesuuryouInfoBeanLst = pTesuuryouInfoBeanLst;
    }

    public int getHnsituHykrankTougetu() {
        return hnsituHykrankTougetu;
    }

    public void setHnsituHykrankTougetu(int pHnsituHykrankTougetu) {
        this.hnsituHykrankTougetu = pHnsituHykrankTougetu;
    }

    public int getHnsituHykrankYokugetu() {
        return hnsituHykrankYokugetu;
    }

    public void setHnsituHykrankYokugetu(int pHnsituHykrankYokugetu) {
        this.hnsituHykrankYokugetu = pHnsituHykrankYokugetu;
    }

    public String getKanjiHoujinSyougou() {
        return kanjiHoujinSyougou;
    }

    public void setKanjiHoujinSyougou(String pKanjiHoujinSyougou) {
        kanjiHoujinSyougou = pKanjiHoujinSyougou;
    }

    public C_Diritenbunruicd getDiritenBunruiCd() {
        return diritenBunruiCd;
    }

    public void setDiritenBunruiCd(C_Diritenbunruicd pDiritenBunruiCd) {
        diritenBunruiCd = pDiritenBunruiCd;
    }

    public C_Channelcd getChannelCd() {
        return channelCd;
    }

    public void setChannelCd(C_Channelcd pChannelCd) {
        channelCd = pChannelCd;
    }

    public C_DrtenChannelSyurui getDrtenChannelSyurui() {
        return drtenChannelSyurui;
    }

    public void setDrtenChannelSyurui(C_DrtenChannelSyurui pDrtenChannelSyurui) {
        drtenChannelSyurui = pDrtenChannelSyurui;
    }

}
