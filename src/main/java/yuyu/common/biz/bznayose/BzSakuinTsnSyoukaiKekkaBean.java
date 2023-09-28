package yuyu.common.biz.bznayose;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_GaitouKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MosHukaKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 索引通算照会結果Beanクラスです。<br />
 */
public class BzSakuinTsnSyoukaiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_MQSyorikekkaKbn mqsyorikekkakbn;

    private C_PalSyoukaiJissiumuKbn palsyoukaijissiumukbn;

    private String acserrcd;

    private C_MQSyoukaiErrorKbn sakuininfosyoukaierrkbn;

    private C_MQSyoukaiErrorKbn mrsyoukaierrkbn;

    private C_MQSyoukaiErrorKbn signalsyoukaierrkbn;

    private C_MQSyoukaiErrorKbn sinsntkhnsysyoukaierrkbn;

    private C_MQSyoukaiErrorKbn tsngksyoukaierrkbn;

    private C_MQSyoukaiErrorKbn kykdrtentsnssyoukaierrkbn;

    private C_MQSyoukaiErrorKbn mossakuseikahisyoukaierrkbn;

    private C_MQSyoukaiErrorKbn hndketyhsyoukaierrkbn;

    private C_NayoseJissiKekkaKbn nysjissikekkakbn;

    private C_NayoseJyoutaiKbn nysjyoutaikbn;

    private String sakuinnmno;

    private int kykmfkensuu;

    private int mosfkensuu;

    private int sntkfkensuu;

    private int sueokifkensuu;

    private int nkfkensuu;

    private int khkensuu;

    private int skkensuu;

    private int nkkensuu;

    private C_BlnktkumuKbn kykmfkensuutyoukaumu;

    private C_BlnktkumuKbn mosfkensuutyoukaumu;

    private C_BlnktkumuKbn sntkfkensuutyoukaumu;

    private C_BlnktkumuKbn sueokifkensuutyoukaumu;

    private C_BlnktkumuKbn nkfkensuutyoukaumu;

    private C_BlnktkumuKbn khkensuutyoukaumu;

    private C_BlnktkumuKbn skkensuutyoukaumu;

    private C_BlnktkumuKbn nkkensuutyoukaumu;

    private List<BzKeiyakuMfSakuinKekkaBean> bzkeiyakumfsakuinkekkabeanlist;

    private List<BzMousikomiFSakuinKekkaBean> bzmousikomifsakuinkekkabeanlist;

    private List<BzSentakuInfoFSakuinKekkaBean> bzsentakuinfofsakuinkekkabeanlist;

    private List<BzHokenkinSueokiFSakuinKekkaBean> bzhokenkinsueokifsakuinkekkabeanlist;

    private List<BzSougouNenkinSiharaiFSakuinKekkaBean> bzsougounenkinsiharaifsakuinkekkabeanlist;

    private List<BzKeiyakuHozenSakuinKekkaBean> bzkeiyakuhozensakuinkekkabeanlist;

    private List<BzSinkeiyakuSakuinKekkaBean> bzsinkeiyakusakuinkekkabeanlist;

    private List<BzNenkinSiharaiSakuinKekkaBean> bznenkinsiharaisakuinkekkabeanlist;

    private C_BlnktkumuKbn sntkinfomrumukbn;

    private C_BlnktkumuKbn sntkinfohnsyumukbn;

    private C_BlnktkumuKbn signalinfoumukbn;

    private C_BlnktkumuKbn signalinfohnsyumukbn;

    private C_BlnktkumuKbn gaikokupepsumukbn;

    private C_BlnktkumuKbn sinsntkhnsyumukbn;

    private BizCurrency tsnsibous;

    private BizCurrency tsnninenmikeikas;

    private BizCurrency tsnninenkeikas;

    private BizCurrency tsnketsibous;

    private BizCurrency tsnketsibous2;

    private BizCurrency tsnsoukktjituhsgk;

    private BizCurrency tsnkktjituhsgk1;

    private BizCurrency tsnkktjituhsgk2;

    private BizCurrency tsnkktitijibrsysnjs;

    private BizCurrency tsnnkgns;

    private BizCurrency tsnmsnynenbtsousbus;

    private BizCurrency tsnnenbtitijibrssbs;

    private BizCurrency tsnitijibrsysnp;

    private BizCurrency tsnninenmikeikahtnkns;

    private BizCurrency tsnninenkeikadfp;

    private BizCurrency tsnsntktuukahijynsysns;

    private C_UmuKbn tsnkaigomehrtkumukbn;

    private BizCurrency kykdrtentsns;

    private C_MosHukaKbn sibouriskmoshukakbn;

    private C_MosHukaKbn kktsibouriskmoshukakbn;

    private C_GaitouKbn itineninaienkigaitoukbn;

    private C_YouhiblnkKbn itekisntkhndktyhkbn;

    private C_YouhiblnkKbn ttdktyuuiknkhndktyhkbn;

    private C_YouhiblnkKbn uktttdktyuuiknkhndktyhkbn;

    private C_YouhiblnkKbn kyhkinuktkariitkhndktyhkbn;

    private C_YouhiblnkKbn doujimositekihndktyhkbn;

    private C_YouhiblnkKbn doujimosknkhndktyhkbn;

    public BzSakuinTsnSyoukaiKekkaBean() {

        super();
    }

    public C_MQSyorikekkaKbn getMqsyorikekkakbn() {
        return mqsyorikekkakbn;
    }

    public void setMqsyorikekkakbn(C_MQSyorikekkaKbn pMqsyorikekkakbn) {
        mqsyorikekkakbn = pMqsyorikekkakbn;
    }

    public C_PalSyoukaiJissiumuKbn getPalsyoukaijissiumukbn() {
        return palsyoukaijissiumukbn;
    }

    public void setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn pPalsyoukaijissiumukbn) {
        palsyoukaijissiumukbn = pPalsyoukaijissiumukbn;
    }

    public String getAcserrcd() {
        return acserrcd;
    }

    public void setAcserrcd(String pAcserrcd) {
        acserrcd = pAcserrcd;
    }

    public C_MQSyoukaiErrorKbn getSakuininfosyoukaierrkbn() {
        return sakuininfosyoukaierrkbn;
    }

    public void setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn pSakuininfosyoukaierrkbn) {
        sakuininfosyoukaierrkbn = pSakuininfosyoukaierrkbn;
    }

    public C_MQSyoukaiErrorKbn getMrsyoukaierrkbn() {
        return mrsyoukaierrkbn;
    }

    public void setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn pMrsyoukaierrkbn) {
        mrsyoukaierrkbn = pMrsyoukaierrkbn;
    }

    public C_MQSyoukaiErrorKbn getSignalsyoukaierrkbn() {
        return signalsyoukaierrkbn;
    }

    public void setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn pSignalsyoukaierrkbn) {
        signalsyoukaierrkbn = pSignalsyoukaierrkbn;
    }

    public C_MQSyoukaiErrorKbn getSinsntkhnsysyoukaierrkbn() {
        return sinsntkhnsysyoukaierrkbn;
    }

    public void setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn pSinsntkhnsysyoukaierrkbn) {
        sinsntkhnsysyoukaierrkbn = pSinsntkhnsysyoukaierrkbn;
    }

    public C_MQSyoukaiErrorKbn getTsngksyoukaierrkbn() {
        return tsngksyoukaierrkbn;
    }

    public void setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn pTsngksyoukaierrkbn) {
        tsngksyoukaierrkbn = pTsngksyoukaierrkbn;
    }

    public C_MQSyoukaiErrorKbn getKykdrtentsnssyoukaierrkbn() {
        return kykdrtentsnssyoukaierrkbn;
    }

    public void setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn pKykdrtentsnssyoukaierrkbn) {
        kykdrtentsnssyoukaierrkbn = pKykdrtentsnssyoukaierrkbn;
    }

    public C_MQSyoukaiErrorKbn getMossakuseikahisyoukaierrkbn() {
        return mossakuseikahisyoukaierrkbn;
    }

    public void setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn pMossakuseikahisyoukaierrkbn) {
        mossakuseikahisyoukaierrkbn = pMossakuseikahisyoukaierrkbn;
    }

    public C_MQSyoukaiErrorKbn getHndketyhsyoukaierrkbn() {
        return hndketyhsyoukaierrkbn;
    }

    public void setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn pHndketyhsyoukaierrkbn) {
        hndketyhsyoukaierrkbn = pHndketyhsyoukaierrkbn;
    }

    public C_NayoseJissiKekkaKbn getNysjissikekkakbn() {
        return nysjissikekkakbn;
    }

    public void setNysjissikekkakbn(C_NayoseJissiKekkaKbn pNysjissikekkakbn) {
        nysjissikekkakbn = pNysjissikekkakbn;
    }

    public C_NayoseJyoutaiKbn getNysjyoutaikbn() {
        return nysjyoutaikbn;
    }

    public void setNysjyoutaikbn(C_NayoseJyoutaiKbn pNysjyoutaikbn) {
        nysjyoutaikbn = pNysjyoutaikbn;
    }

    public String getSakuinnmno() {
        return sakuinnmno;
    }

    public void setSakuinnmno(String pSakuinnmno) {
        sakuinnmno = pSakuinnmno;
    }
    public int getKykmfkensuu() {
        return kykmfkensuu;
    }

    public void setKykmfkensuu(int pKykmfkensuu) {
        kykmfkensuu = pKykmfkensuu;
    }

    public int getMosfkensuu() {
        return mosfkensuu;
    }

    public void setMosfkensuu(int pMosfkensuu) {
        mosfkensuu = pMosfkensuu;
    }

    public int getSntkfkensuu() {
        return sntkfkensuu;
    }

    public void setSntkfkensuu(int pSntkfkensuu) {
        sntkfkensuu = pSntkfkensuu;
    }

    public int getSueokifkensuu() {
        return sueokifkensuu;
    }

    public void setSueokifkensuu(int pSueokifkensuu) {
        sueokifkensuu = pSueokifkensuu;
    }

    public int getNkfkensuu() {
        return nkfkensuu;
    }

    public void setNkfkensuu(int pNkfkensuu) {
        nkfkensuu = pNkfkensuu;
    }

    public int getKhkensuu() {
        return khkensuu;
    }

    public void setKhkensuu(int pKhkensuu) {
        khkensuu = pKhkensuu;
    }

    public int getSkkensuu() {
        return skkensuu;
    }

    public void setSkkensuu(int pSkkensuu) {
        skkensuu = pSkkensuu;
    }

    public int getNkkensuu() {
        return nkkensuu;
    }

    public void setNkkensuu(int pNkkensuu) {
        nkkensuu = pNkkensuu;
    }

    public C_BlnktkumuKbn getKykmfkensuutyoukaumu() {
        return kykmfkensuutyoukaumu;
    }

    public void setKykmfkensuutyoukaumu(C_BlnktkumuKbn pKykmfkensuutyoukaumu) {
        kykmfkensuutyoukaumu = pKykmfkensuutyoukaumu;
    }

    public C_BlnktkumuKbn getMosfkensuutyoukaumu() {
        return mosfkensuutyoukaumu;
    }

    public void setMosfkensuutyoukaumu(C_BlnktkumuKbn pMosfkensuutyoukaumu) {
        mosfkensuutyoukaumu = pMosfkensuutyoukaumu;
    }

    public C_BlnktkumuKbn getSntkfkensuutyoukaumu() {
        return sntkfkensuutyoukaumu;
    }

    public void setSntkfkensuutyoukaumu(C_BlnktkumuKbn pSntkfkensuutyoukaumu) {
        sntkfkensuutyoukaumu = pSntkfkensuutyoukaumu;
    }

    public C_BlnktkumuKbn getSueokifkensuutyoukaumu() {
        return sueokifkensuutyoukaumu;
    }

    public void setSueokifkensuutyoukaumu(C_BlnktkumuKbn pSueokifkensuutyoukaumu) {
        sueokifkensuutyoukaumu = pSueokifkensuutyoukaumu;
    }

    public C_BlnktkumuKbn getNkfkensuutyoukaumu() {
        return nkfkensuutyoukaumu;
    }

    public void setNkfkensuutyoukaumu(C_BlnktkumuKbn pNkfkensuutyoukaumu) {
        nkfkensuutyoukaumu = pNkfkensuutyoukaumu;
    }

    public C_BlnktkumuKbn getKhkensuutyoukaumu() {
        return khkensuutyoukaumu;
    }

    public void setKhkensuutyoukaumu(C_BlnktkumuKbn pKhkensuutyoukaumu) {
        khkensuutyoukaumu = pKhkensuutyoukaumu;
    }

    public C_BlnktkumuKbn getSkkensuutyoukaumu() {
        return skkensuutyoukaumu;
    }

    public void setSkkensuutyoukaumu(C_BlnktkumuKbn pSkkensuutyoukaumu) {
        skkensuutyoukaumu = pSkkensuutyoukaumu;
    }

    public C_BlnktkumuKbn getNkkensuutyoukaumu() {
        return nkkensuutyoukaumu;
    }

    public void setNkkensuutyoukaumu(C_BlnktkumuKbn pNkkensuutyoukaumu) {
        nkkensuutyoukaumu = pNkkensuutyoukaumu;
    }

    public List<BzKeiyakuMfSakuinKekkaBean> getBzkeiyakumfsakuinkekkabeanlist() {
        return bzkeiyakumfsakuinkekkabeanlist;
    }

    public void setBzkeiyakumfsakuinkekkabeanlist(List<BzKeiyakuMfSakuinKekkaBean> pBzkeiyakumfsakuinkekkabeanlist) {
        bzkeiyakumfsakuinkekkabeanlist = pBzkeiyakumfsakuinkekkabeanlist;
    }

    public List<BzMousikomiFSakuinKekkaBean> getBzmousikomifsakuinkekkabeanlist() {
        return bzmousikomifsakuinkekkabeanlist;
    }

    public void setBzmousikomifsakuinkekkabeanlist(List<BzMousikomiFSakuinKekkaBean> pBzmousikomifsakuinkekkabeanlist) {
        bzmousikomifsakuinkekkabeanlist = pBzmousikomifsakuinkekkabeanlist;
    }

    public List<BzSentakuInfoFSakuinKekkaBean> getBzsentakuinfofsakuinkekkabeanlist() {
        return bzsentakuinfofsakuinkekkabeanlist;
    }

    public void setBzsentakuinfofsakuinkekkabeanlist(List<BzSentakuInfoFSakuinKekkaBean> pBzsentakuinfofsakuinkekkabeanlist) {
        bzsentakuinfofsakuinkekkabeanlist = pBzsentakuinfofsakuinkekkabeanlist;
    }

    public List<BzHokenkinSueokiFSakuinKekkaBean> getBzhokenkinsueokifsakuinkekkabeanlist() {
        return bzhokenkinsueokifsakuinkekkabeanlist;
    }

    public void setBzhokenkinsueokifsakuinkekkabeanlist(List<BzHokenkinSueokiFSakuinKekkaBean> pBzhokenkinsueokifsakuinkekkabeanlist) {
        bzhokenkinsueokifsakuinkekkabeanlist = pBzhokenkinsueokifsakuinkekkabeanlist;
    }

    public List<BzSougouNenkinSiharaiFSakuinKekkaBean> getBzsougounenkinsiharaifsakuinkekkabeanlist() {
        return bzsougounenkinsiharaifsakuinkekkabeanlist;
    }

    public void setBzsougounenkinsiharaifsakuinkekkabeanlist(List<BzSougouNenkinSiharaiFSakuinKekkaBean> pBzsougounenkinsiharaifsakuinkekkabeanlist) {
        bzsougounenkinsiharaifsakuinkekkabeanlist = pBzsougounenkinsiharaifsakuinkekkabeanlist;
    }

    public List<BzKeiyakuHozenSakuinKekkaBean> getBzkeiyakuhozensakuinkekkabeanlist() {
        return bzkeiyakuhozensakuinkekkabeanlist;
    }

    public void setBzkeiyakuhozensakuinkekkabeanlist(List<BzKeiyakuHozenSakuinKekkaBean> pBzkeiyakuhozensakuinkekkabeanlist) {
        bzkeiyakuhozensakuinkekkabeanlist = pBzkeiyakuhozensakuinkekkabeanlist;
    }

    public List<BzSinkeiyakuSakuinKekkaBean> getBzsinkeiyakusakuinkekkabeanlist() {
        return bzsinkeiyakusakuinkekkabeanlist;
    }

    public void setBzsinkeiyakusakuinkekkabeanlist(List<BzSinkeiyakuSakuinKekkaBean> pBzsinkeiyakusakuinkekkabeanlist) {
        bzsinkeiyakusakuinkekkabeanlist = pBzsinkeiyakusakuinkekkabeanlist;
    }

    public List<BzNenkinSiharaiSakuinKekkaBean> getBznenkinsiharaisakuinkekkabeanlist() {
        return bznenkinsiharaisakuinkekkabeanlist;
    }

    public void setBznenkinsiharaisakuinkekkabeanlist(List<BzNenkinSiharaiSakuinKekkaBean> pBznenkinsiharaisakuinkekkabeanlist) {
        bznenkinsiharaisakuinkekkabeanlist = pBznenkinsiharaisakuinkekkabeanlist;
    }

    public C_BlnktkumuKbn getSntkinfomrumukbn() {
        return sntkinfomrumukbn;
    }

    public void setSntkinfomrumukbn(C_BlnktkumuKbn pSntkinfomrumukbn) {
        sntkinfomrumukbn = pSntkinfomrumukbn;
    }

    public C_BlnktkumuKbn getSntkinfohnsyumukbn() {
        return sntkinfohnsyumukbn;
    }

    public void setSntkinfohnsyumukbn(C_BlnktkumuKbn pSntkinfohnsyumukbn) {
        sntkinfohnsyumukbn = pSntkinfohnsyumukbn;
    }

    public C_BlnktkumuKbn getSignalinfoumukbn() {
        return signalinfoumukbn;
    }

    public void setSignalinfoumukbn(C_BlnktkumuKbn pSignalinfoumukbn) {
        signalinfoumukbn = pSignalinfoumukbn;
    }

    public C_BlnktkumuKbn getSignalinfohnsyumukbn() {
        return signalinfohnsyumukbn;
    }

    public void setSignalinfohnsyumukbn(C_BlnktkumuKbn pSignalinfohnsyumukbn) {
        signalinfohnsyumukbn = pSignalinfohnsyumukbn;
    }

    public C_BlnktkumuKbn getGaikokupepsumukbn() {
        return gaikokupepsumukbn;
    }

    public void setGaikokupepsumukbn(C_BlnktkumuKbn pGaikokupepsumukbn) {
        gaikokupepsumukbn = pGaikokupepsumukbn;
    }

    public C_BlnktkumuKbn getSinsntkhnsyumukbn() {
        return sinsntkhnsyumukbn;
    }

    public void setSinsntkhnsyumukbn(C_BlnktkumuKbn pSinsntkhnsyumukbn) {
        sinsntkhnsyumukbn = pSinsntkhnsyumukbn;
    }

    public BizCurrency getTsnsibous() {
        return tsnsibous;
    }

    public void setTsnsibous(BizCurrency pTsnsibous) {
        tsnsibous = pTsnsibous;
    }

    public BizCurrency getTsnninenmikeikas() {
        return tsnninenmikeikas;
    }

    public void setTsnninenmikeikas(BizCurrency pTsnninenmikeikas) {
        tsnninenmikeikas = pTsnninenmikeikas;
    }

    public BizCurrency getTsnninenkeikas() {
        return tsnninenkeikas;
    }

    public void setTsnninenkeikas(BizCurrency pTsnninenkeikas) {
        tsnninenkeikas = pTsnninenkeikas;
    }

    public BizCurrency getTsnketsibous() {
        return tsnketsibous;
    }

    public void setTsnketsibous(BizCurrency pTsnketsibous) {
        tsnketsibous = pTsnketsibous;
    }

    public BizCurrency getTsnketsibous2() {
        return tsnketsibous2;
    }

    public void setTsnketsibous2(BizCurrency pTsnketsibous2) {
        tsnketsibous2 = pTsnketsibous2;
    }

    public BizCurrency getTsnsoukktjituhsgk() {
        return tsnsoukktjituhsgk;
    }

    public void setTsnsoukktjituhsgk(BizCurrency pTsnsoukktjituhsgk) {
        tsnsoukktjituhsgk = pTsnsoukktjituhsgk;
    }

    public BizCurrency getTsnkktjituhsgk1() {
        return tsnkktjituhsgk1;
    }

    public void setTsnkktjituhsgk1(BizCurrency pTsnkktjituhsgk1) {
        tsnkktjituhsgk1 = pTsnkktjituhsgk1;
    }

    public BizCurrency getTsnkktjituhsgk2() {
        return tsnkktjituhsgk2;
    }

    public void setTsnkktjituhsgk2(BizCurrency pTsnkktjituhsgk2) {
        tsnkktjituhsgk2 = pTsnkktjituhsgk2;
    }

    public BizCurrency getTsnkktitijibrsysnjs() {
        return tsnkktitijibrsysnjs;
    }

    public void setTsnkktitijibrsysnjs(BizCurrency pTsnkktitijibrsysnjs) {
        tsnkktitijibrsysnjs = pTsnkktitijibrsysnjs;
    }

    public BizCurrency getTsnnkgns() {
        return tsnnkgns;
    }

    public void setTsnnkgns(BizCurrency pTsnnkgns) {
        tsnnkgns = pTsnnkgns;
    }

    public BizCurrency getTsnmsnynenbtsousbus() {
        return tsnmsnynenbtsousbus;
    }

    public void setTsnmsnynenbtsousbus(BizCurrency pTsnmsnynenbtsousbus) {
        tsnmsnynenbtsousbus = pTsnmsnynenbtsousbus;
    }

    public BizCurrency getTsnnenbtitijibrssbs() {
        return tsnnenbtitijibrssbs;
    }

    public void setTsnnenbtitijibrssbs(BizCurrency pTsnnenbtitijibrssbs) {
        tsnnenbtitijibrssbs = pTsnnenbtitijibrssbs;
    }


    public BizCurrency getTsnitijibrsysnp() {
        return tsnitijibrsysnp;
    }

    public void setTsnitijibrsysnp(BizCurrency pTsnitijibrsysnp) {
        tsnitijibrsysnp = pTsnitijibrsysnp;
    }

    public BizCurrency getTsnninenmikeikahtnkns() {
        return tsnninenmikeikahtnkns;
    }

    public void setTsnninenmikeikahtnkns(BizCurrency pTsnninenmikeikahtnkns) {
        tsnninenmikeikahtnkns = pTsnninenmikeikahtnkns;
    }

    public BizCurrency getTsnninenkeikadfp() {
        return tsnninenkeikadfp;
    }

    public void setTsnninenkeikadfp(BizCurrency pTsnninenkeikadfp) {
        tsnninenkeikadfp = pTsnninenkeikadfp;
    }

    public BizCurrency getTsnsntktuukahijynsysns() {
        return tsnsntktuukahijynsysns;
    }

    public void setTsnsntktuukahijynsysns(BizCurrency pTsnsntktuukahijynsysns) {
        tsnsntktuukahijynsysns = pTsnsntktuukahijynsysns;
    }

    public C_UmuKbn getTsnkaigomehrtkumukbn() {
        return tsnkaigomehrtkumukbn;
    }

    public void setTsnkaigomehrtkumukbn(C_UmuKbn pTsnkaigomehrtkumukbn) {
        tsnkaigomehrtkumukbn = pTsnkaigomehrtkumukbn;
    }

    public BizCurrency getKykdrtentsns() {
        return kykdrtentsns;
    }

    public void setKykdrtentsns(BizCurrency pKykdrtentsns) {
        kykdrtentsns = pKykdrtentsns;
    }

    public C_MosHukaKbn getSibouriskmoshukakbn() {
        return sibouriskmoshukakbn;
    }

    public void setSibouriskmoshukakbn(C_MosHukaKbn pSibouriskmoshukakbn) {
        sibouriskmoshukakbn = pSibouriskmoshukakbn;
    }

    public C_MosHukaKbn getKktsibouriskmoshukakbn() {
        return kktsibouriskmoshukakbn;
    }

    public void setKktsibouriskmoshukakbn(C_MosHukaKbn pKktsibouriskmoshukakbn) {
        kktsibouriskmoshukakbn = pKktsibouriskmoshukakbn;
    }

    public C_GaitouKbn getItineninaienkigaitoukbn() {
        return itineninaienkigaitoukbn;
    }

    public void setItineninaienkigaitoukbn(C_GaitouKbn pItineninaienkigaitoukbn) {
        itineninaienkigaitoukbn = pItineninaienkigaitoukbn;
    }

    public C_YouhiblnkKbn getItekisntkhndktyhkbn() {
        return itekisntkhndktyhkbn;
    }

    public void setItekisntkhndktyhkbn(C_YouhiblnkKbn pItekisntkhndktyhkbn) {
        itekisntkhndktyhkbn = pItekisntkhndktyhkbn;
    }

    public C_YouhiblnkKbn getTtdktyuuiknkhndktyhkbn() {
        return ttdktyuuiknkhndktyhkbn;
    }

    public void setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn pTtdktyuuiknkhndktyhkbn) {
        ttdktyuuiknkhndktyhkbn = pTtdktyuuiknkhndktyhkbn;
    }

    public C_YouhiblnkKbn getUktttdktyuuiknkhndktyhkbn() {
        return uktttdktyuuiknkhndktyhkbn;
    }

    public void setUktttdktyuuiknkhndktyhkbn(C_YouhiblnkKbn pUktttdktyuuiknkhndktyhkbn) {
        uktttdktyuuiknkhndktyhkbn = pUktttdktyuuiknkhndktyhkbn;
    }
    public C_YouhiblnkKbn getKyhkinuktkariitkhndktyhkbn() {
        return kyhkinuktkariitkhndktyhkbn;
    }

    public void setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn pKyhkinuktkariitkhndktyhkbn) {
        kyhkinuktkariitkhndktyhkbn = pKyhkinuktkariitkhndktyhkbn;
    }

    public C_YouhiblnkKbn getDoujimositekihndktyhkbn() {
        return doujimositekihndktyhkbn;
    }

    public void setDoujimositekihndktyhkbn(C_YouhiblnkKbn pDoujimositekihndktyhkbn) {
        doujimositekihndktyhkbn = pDoujimositekihndktyhkbn;
    }

    public C_YouhiblnkKbn getDoujimosknkhndktyhkbn() {
        return doujimosknkhndktyhkbn;
    }

    public void setDoujimosknkhndktyhkbn(C_YouhiblnkKbn pDoujimosknkhndktyhkbn) {
        doujimosknkhndktyhkbn = pDoujimosknkhndktyhkbn;
    }

}
