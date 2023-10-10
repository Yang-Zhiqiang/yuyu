package yuyu.app.hozen.khozen.khtetudukityuui;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiUiBeanParam;
import yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKyksyadairiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTrkKazokuExecUiBeanParam;
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoiSyoriKbn;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 契約保全手続注意設定 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhTetudukiTyuuiUiBean extends GenKhTetudukiTyuuiUiBean implements CheckYuukouJyoutaiExecUiBeanParam,
SetToriatukaiTyuuiExecUiBeanParam, SetKihonExecUiBeanParam,
SetBetukykExecUiBeanParam, SetKeiyakusyaExecUiBeanParam, SetHihokensyaExecUiBeanParam,
ViewKihonUiBeanParam, ViewBetukykUiBeanParam, ViewKeiyakusyaUiBeanParam, ViewHihokensyaUiBeanParam,
ViewTrkKazokuUiBeanParam, SetTrkKazokuExecUiBeanParam, ViewKyksyadairiUiBeanParam, SetKyksyadairiExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private IT_KykKihon kykKihon;

    private C_KktyuitaKbn bfrKktyuitakbn;

    private String bfrTtdktyuuinaiyou1;

    private String bfrTtdktyuuinaiyou2;

    private String bfrTtdktyuuinaiyou3;

    private boolean ttdktyuuiHnkUmu;

    private C_UmuKbn stknUmu;

    private C_StknsetKbn bfrStknsetKbn;

    private int bfrFatcatgkbnSize;

    private Integer renno1;

    private Integer renno2;

    private Integer renno3;

    private Integer renno4;

    private Integer renno5;

    private Integer bfrrenno1;

    private Integer bfrrenno2;

    private Integer bfrrenno3;

    private Integer bfrrenno4;

    private Integer bfrrenno5;

    private BizDate bfrSyoriymd1;

    private String syoriSosikicd1;

    private C_FatcasnsiKbn bfrfatcasnsikbn1;

    private C_BikkjnssinfoKbn bfrbikkjnssinfokbn1;

    private C_FatcakekKbn bfrfatcakekkbn1;

    private C_FatcahankeiiKbn bfrfatcahankeiikbn1;

    private String bfrbikknzsyno1;

    private BizDate bfrsyomeiymd1;

    private C_FatcatgKbn bfrfatcatgkbn1;

    private String bfrnmkn1;

    private String bfrnmkj1;

    private BizDate bfrseiymd1;

    private C_Seibetu bfrsei1;

    private BizDate bfrKouryokuendymd1;

    private BizDate bfrSyoriymd2;

    private String syoriSosikicd2;

    private C_FatcasnsiKbn bfrfatcasnsikbn2;

    private C_BikkjnssinfoKbn bfrbikkjnssinfokbn2;

    private C_FatcakekKbn bfrfatcakekkbn2;

    private C_FatcahankeiiKbn bfrfatcahankeiikbn2;

    private String bfrbikknzsyno2;

    private BizDate bfrsyomeiymd2;

    private C_FatcatgKbn bfrfatcatgkbn2;

    private String bfrnmkn2;

    private String bfrnmkj2;

    private BizDate bfrseiymd2;

    private C_Seibetu bfrsei2;

    private BizDate bfrKouryokuendymd2;

    private BizDate bfrSyoriymd3;

    private String syoriSosikicd3;

    private C_FatcasnsiKbn bfrfatcasnsikbn3;

    private C_BikkjnssinfoKbn bfrbikkjnssinfokbn3;

    private C_FatcakekKbn bfrfatcakekkbn3;

    private C_FatcahankeiiKbn bfrfatcahankeiikbn3;

    private String bfrbikknzsyno3;

    private BizDate bfrsyomeiymd3;

    private C_FatcatgKbn bfrfatcatgkbn3;

    private String bfrnmkn3;

    private String bfrnmkj3;

    private BizDate bfrseiymd3;

    private C_Seibetu bfrsei3;

    private BizDate bfrKouryokuendymd3;

    private BizDate bfrSyoriymd4;

    private String syoriSosikicd4;

    private C_FatcasnsiKbn bfrfatcasnsikbn4;

    private C_BikkjnssinfoKbn bfrbikkjnssinfokbn4;

    private C_FatcakekKbn bfrfatcakekkbn4;

    private C_FatcahankeiiKbn bfrfatcahankeiikbn4;

    private String bfrbikknzsyno4;

    private BizDate bfrsyomeiymd4;

    private C_FatcatgKbn bfrfatcatgkbn4;

    private String bfrnmkn4;

    private String bfrnmkj4;

    private BizDate bfrseiymd4;

    private C_Seibetu bfrsei4;

    private BizDate bfrKouryokuendymd4;

    private BizDate bfrSyoriymd5;

    private String syoriSosikicd5;

    private C_FatcasnsiKbn bfrfatcasnsikbn5;

    private C_BikkjnssinfoKbn bfrbikkjnssinfokbn5;

    private C_FatcakekKbn bfrfatcakekkbn5;

    private C_FatcahankeiiKbn bfrfatcahankeiikbn5;

    private String bfrbikknzsyno5;

    private BizDate bfrsyomeiymd5;

    private C_FatcatgKbn bfrfatcatgkbn5;

    private String bfrnmkn5;

    private String bfrnmkj5;

    private BizDate bfrseiymd5;

    private C_Seibetu bfrsei5;

    private BizDate bfrKouryokuendymd5;

    private boolean fatcaHnkFlg1;

    private boolean fatcaHnkFlg2;

    private boolean fatcaHnkFlg3;

    private boolean fatcaHnkFlg4;

    private boolean fatcaHnkFlg5;

    private int bfrAeoiRecordKensuu;

    private Integer aeoiRenno1;

    private Integer aeoiRenno2;

    private Integer aeoiRenno3;

    private Integer aeoiRenno4;

    private Integer aeoiRenno5;

    private Integer bfrAeoiRenno1;

    private Integer bfrAeoiRenno2;

    private Integer bfrAeoiRenno3;

    private Integer bfrAeoiRenno4;

    private Integer bfrAeoiRenno5;

    private boolean bfrAeoiSakujyo1;

    private BizDate bfrAeoiSyoriymd1;

    private String bfrAeoiSyorisosikicd1;

    private C_AeoiKekkaKbn bfrAeoiKekkakbn1;

    private C_AeoiSyoriKbn bfrAeoiSyorikbn1;

    private C_AeoiTaisyousyaKbn bfrAeoiTaisyousyakbn1;

    private C_AeoiHoujinSyuruiKbn bfrAeoiHoujinsyuruikbn1;

    private BizDate bfrAeoiKouryokusttymd1;

    private BizDate bfrAeoiKouryokuendymd1;

    private boolean bfrAeoiSakujyo2;

    private BizDate bfrAeoiSyoriymd2;

    private String bfrAeoiSyorisosikicd2;

    private C_AeoiKekkaKbn bfrAeoiKekkakbn2;

    private C_AeoiSyoriKbn bfrAeoiSyorikbn2;

    private C_AeoiTaisyousyaKbn bfrAeoiTaisyousyakbn2;

    private C_AeoiHoujinSyuruiKbn bfrAeoiHoujinsyuruikbn2;

    private BizDate bfrAeoiKouryokusttymd2;

    private BizDate bfrAeoiKouryokuendymd2;

    private boolean bfrAeoiSakujyo3;

    private BizDate bfrAeoiSyoriymd3;

    private String bfrAeoiSyorisosikicd3;

    private C_AeoiKekkaKbn bfrAeoiKekkakbn3;

    private C_AeoiSyoriKbn bfrAeoiSyorikbn3;

    private C_AeoiTaisyousyaKbn bfrAeoiTaisyousyakbn3;

    private C_AeoiHoujinSyuruiKbn bfrAeoiHoujinsyuruikbn3;

    private BizDate bfrAeoiKouryokusttymd3;

    private BizDate bfrAeoiKouryokuendymd3;

    private boolean bfrAeoiSakujyo4;

    private BizDate bfrAeoiSyoriymd4;

    private String bfrAeoiSyorisosikicd4;

    private C_AeoiKekkaKbn bfrAeoiKekkakbn4;

    private C_AeoiSyoriKbn bfrAeoiSyorikbn4;

    private C_AeoiTaisyousyaKbn bfrAeoiTaisyousyakbn4;

    private C_AeoiHoujinSyuruiKbn bfrAeoiHoujinsyuruikbn4;

    private BizDate bfrAeoiKouryokusttymd4;

    private BizDate bfrAeoiKouryokuendymd4;

    private boolean bfrAeoiSakujyo5;

    private BizDate bfrAeoiSyoriymd5;

    private String bfrAeoiSyorisosikicd5;

    private C_AeoiKekkaKbn bfrAeoiKekkakbn5;

    private C_AeoiSyoriKbn bfrAeoiSyorikbn5;

    private C_AeoiTaisyousyaKbn bfrAeoiTaisyousyakbn5;

    private C_AeoiHoujinSyuruiKbn bfrAeoiHoujinsyuruikbn5;

    private BizDate bfrAeoiKouryokusttymd5;

    private BizDate bfrAeoiKouryokuendymd5;

    private boolean aeoiHnkFlg1;

    private boolean aeoiHnkFlg2;

    private boolean aeoiHnkFlg3;

    private boolean aeoiHnkFlg4;

    private boolean aeoiHnkFlg5;


    private C_UmuKbn mosuktymdhkumu;

    private String hhknyno;

    private String hhknadr1kj;

    private String hhknadr2kj;

    private String hhknadr3kj;

    private String hhknadr4kj;

    private String hhkntelno;

    private String syono;

    private List<String> warningMessageIdList;

    private List<String> warningMessageList;

    private DataSource<TtdkTyuui1DataSourceBean> bfrTtdkTyuui1DataSource = new DataSource<>();

    private C_UmuKbn kykdrtkykumu;

    private C_KykdrknHtdjytKbn brfKykdrknhatudoujyoutai;

    private C_KykdrDouiYouhiKbn brfKykdrdouiyouhi;

    private boolean kykdrknhatudouHnkFlg;

    private boolean kykdrdouiyouhiHnkFlg;

    private String reportKey;

    private C_UmuKbn tyouhyoumukbn;

    public KhTetudukiTyuuiUiBean() {
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;

    }

    public C_KktyuitaKbn getBfrKktyuitakbn() {
        return bfrKktyuitakbn;
    }

    public void setBfrKktyuitakbn(C_KktyuitaKbn pBfrKktyuitakbn) {
        bfrKktyuitakbn = pBfrKktyuitakbn;
    }

    public String getBfrTtdktyuuinaiyou1() {
        return bfrTtdktyuuinaiyou1;
    }

    public void setBfrTtdktyuuinaiyou1(String pBfrTtdktyuuinaiyou1) {
        bfrTtdktyuuinaiyou1 = pBfrTtdktyuuinaiyou1;
    }

    public String getBfrTtdktyuuinaiyou2() {
        return bfrTtdktyuuinaiyou2;
    }

    public void setBfrTtdktyuuinaiyou2(String pBfrTtdktyuuinaiyou2) {
        bfrTtdktyuuinaiyou2 = pBfrTtdktyuuinaiyou2;
    }

    public String getBfrTtdktyuuinaiyou3() {
        return bfrTtdktyuuinaiyou3;
    }

    public void setBfrTtdktyuuinaiyou3(String pBfrTtdktyuuinaiyou3) {
        bfrTtdktyuuinaiyou3 = pBfrTtdktyuuinaiyou3;
    }

    public boolean isTtdktyuuiHnkUmu() {
        return ttdktyuuiHnkUmu;
    }

    public void setTtdktyuuiHnkUmu(boolean ttdktyuuiHnkUmu) {
        this.ttdktyuuiHnkUmu = ttdktyuuiHnkUmu;
    }

    public C_UmuKbn getStknUmu() {
        return stknUmu;
    }

    public void setStknUmu(C_UmuKbn pStknUmu) {
        stknUmu = pStknUmu;
    }

    public C_StknsetKbn getBfrStknsetKbn() {
        return bfrStknsetKbn;
    }

    public void setBfrStknsetKbn(C_StknsetKbn pBfrStknsetKbn) {
        bfrStknsetKbn = pBfrStknsetKbn;
    }

    public int getBfrFatcatgkbnSize() {
        return bfrFatcatgkbnSize;
    }

    public void setBfrFatcatgkbnSize(int pBfrFatcatgkbnSize) {
        bfrFatcatgkbnSize = pBfrFatcatgkbnSize;
    }

    public Integer getRenno1() {
        return renno1;
    }

    public void setRenno1(Integer pRenno1) {
        renno1 = pRenno1;
    }

    public Integer getRenno2() {
        return renno2;
    }

    public void setRenno2(Integer pRenno2) {
        renno2 = pRenno2;
    }

    public Integer getRenno3() {
        return renno3;
    }

    public void setRenno3(Integer pRenno3) {
        renno3 = pRenno3;
    }

    public Integer getRenno4() {
        return renno4;
    }

    public void setRenno4(Integer pRenno4) {
        renno4 = pRenno4;
    }

    public Integer getRenno5() {
        return renno5;
    }

    public void setRenno5(Integer pRenno5) {
        renno5 = pRenno5;
    }

    public Integer getBfrrenno1() {
        return bfrrenno1;
    }

    public void setBfrrenno1(Integer pBfrrenno1) {
        bfrrenno1 = pBfrrenno1;
    }

    public Integer getBfrrenno2() {
        return bfrrenno2;
    }

    public void setBfrrenno2(Integer pBfrrenno2) {
        bfrrenno2 = pBfrrenno2;
    }

    public Integer getBfrrenno3() {
        return bfrrenno3;
    }

    public void setBfrrenno3(Integer pBfrrenno3) {
        bfrrenno3 = pBfrrenno3;
    }

    public Integer getBfrrenno4() {
        return bfrrenno4;
    }

    public void setBfrrenno4(Integer pBfrrenno4) {
        bfrrenno4 = pBfrrenno4;
    }

    public Integer getBfrrenno5() {
        return bfrrenno5;
    }

    public void setBfrrenno5(Integer pBfrrenno5) {
        bfrrenno5 = pBfrrenno5;
    }

    public BizDate getBfrSyoriymd1() {
        return bfrSyoriymd1;
    }

    public void setBfrSyoriymd1(BizDate pBfrSyoriymd1) {
        bfrSyoriymd1 = pBfrSyoriymd1;
    }

    public String getSyoriSosikicd1() {
        return syoriSosikicd1;
    }

    public void setSyoriSosikicd1(String pSyoriSosikicd1) {
        syoriSosikicd1 = pSyoriSosikicd1;
    }

    public C_FatcasnsiKbn getBfrfatcasnsikbn1() {
        return bfrfatcasnsikbn1;
    }

    public void setBfrfatcasnsikbn1(C_FatcasnsiKbn pBfrfatcasnsikbn1) {
        bfrfatcasnsikbn1 = pBfrfatcasnsikbn1;
    }

    public C_BikkjnssinfoKbn getBfrbikkjnssinfokbn1() {
        return bfrbikkjnssinfokbn1;
    }

    public void setBfrbikkjnssinfokbn1(C_BikkjnssinfoKbn pBfrbikkjnssinfokbn1) {
        bfrbikkjnssinfokbn1 = pBfrbikkjnssinfokbn1;
    }

    public C_FatcakekKbn getBfrfatcakekkbn1() {
        return bfrfatcakekkbn1;
    }

    public void setBfrfatcakekkbn1(C_FatcakekKbn pBfrfatcakekkbn1) {
        bfrfatcakekkbn1 = pBfrfatcakekkbn1;
    }

    public C_FatcahankeiiKbn getBfrfatcahankeiikbn1() {
        return bfrfatcahankeiikbn1;
    }

    public void setBfrfatcahankeiikbn1(C_FatcahankeiiKbn pBfrfatcahankeiikbn1) {
        bfrfatcahankeiikbn1 = pBfrfatcahankeiikbn1;
    }

    public String getBfrbikknzsyno1() {
        return bfrbikknzsyno1;
    }

    public void setBfrbikknzsyno1(String pBfrbikknzsyno1) {
        bfrbikknzsyno1 = pBfrbikknzsyno1;
    }

    public BizDate getBfrsyomeiymd1() {
        return bfrsyomeiymd1;
    }

    public void setBfrsyomeiymd1(BizDate pBfrsyomeiymd1) {
        bfrsyomeiymd1 = pBfrsyomeiymd1;
    }

    public C_FatcatgKbn getBfrfatcatgkbn1() {
        return bfrfatcatgkbn1;
    }

    public void setBfrfatcatgkbn1(C_FatcatgKbn pBfrfatcatgkbn1) {
        bfrfatcatgkbn1 = pBfrfatcatgkbn1;
    }

    public String getBfrnmkn1() {
        return bfrnmkn1;
    }

    public void setBfrnmkn1(String pBfrnmkn1) {
        bfrnmkn1 = pBfrnmkn1;
    }

    public String getBfrnmkj1() {
        return bfrnmkj1;
    }

    public void setBfrnmkj1(String pBfrnmkj1) {
        bfrnmkj1 = pBfrnmkj1;
    }

    public BizDate getBfrseiymd1() {
        return bfrseiymd1;
    }

    public void setBfrseiymd1(BizDate pBfrseiymd1) {
        bfrseiymd1 = pBfrseiymd1;
    }

    public C_Seibetu getBfrsei1() {
        return bfrsei1;
    }

    public void setBfrsei1(C_Seibetu pBfrsei1) {
        bfrsei1 = pBfrsei1;
    }

    public BizDate getBfrKouryokuendymd1() {
        return bfrKouryokuendymd1;
    }

    public void setBfrKouryokuendymd1(BizDate pKouryokuendymd1) {
        bfrKouryokuendymd1 = pKouryokuendymd1;
    }

    public BizDate getBfrSyoriymd2() {
        return bfrSyoriymd2;
    }

    public void setBfrSyoriymd2(BizDate pBfrSyoriymd2) {
        bfrSyoriymd2 = pBfrSyoriymd2;
    }

    public String getSyoriSosikicd2() {
        return syoriSosikicd2;
    }

    public void setSyoriSosikicd2(String pSyoriSosikicd2) {
        syoriSosikicd2 = pSyoriSosikicd2;
    }

    public C_FatcasnsiKbn getBfrfatcasnsikbn2() {
        return bfrfatcasnsikbn2;
    }

    public void setBfrfatcasnsikbn2(C_FatcasnsiKbn pBfrfatcasnsikbn2) {
        bfrfatcasnsikbn2 = pBfrfatcasnsikbn2;
    }

    public C_BikkjnssinfoKbn getBfrbikkjnssinfokbn2() {
        return bfrbikkjnssinfokbn2;
    }

    public void setBfrbikkjnssinfokbn2(C_BikkjnssinfoKbn pBfrbikkjnssinfokbn2) {
        bfrbikkjnssinfokbn2 = pBfrbikkjnssinfokbn2;
    }

    public C_FatcakekKbn getBfrfatcakekkbn2() {
        return bfrfatcakekkbn2;
    }

    public void setBfrfatcakekkbn2(C_FatcakekKbn pBfrfatcakekkbn2) {
        bfrfatcakekkbn2 = pBfrfatcakekkbn2;
    }

    public C_FatcahankeiiKbn getBfrfatcahankeiikbn2() {
        return bfrfatcahankeiikbn2;
    }

    public void setBfrfatcahankeiikbn2(C_FatcahankeiiKbn pBfrfatcahankeiikbn2) {
        bfrfatcahankeiikbn2 = pBfrfatcahankeiikbn2;
    }

    public String getBfrbikknzsyno2() {
        return bfrbikknzsyno2;
    }

    public void setBfrbikknzsyno2(String pBfrbikknzsyno2) {
        bfrbikknzsyno2 = pBfrbikknzsyno2;
    }

    public BizDate getBfrsyomeiymd2() {
        return bfrsyomeiymd2;
    }

    public void setBfrsyomeiymd2(BizDate pBfrsyomeiymd2) {
        bfrsyomeiymd2 = pBfrsyomeiymd2;
    }

    public C_FatcatgKbn getBfrfatcatgkbn2() {
        return bfrfatcatgkbn2;
    }

    public void setBfrfatcatgkbn2(C_FatcatgKbn pBfrfatcatgkbn2) {
        bfrfatcatgkbn2 = pBfrfatcatgkbn2;
    }

    public String getBfrnmkn2() {
        return bfrnmkn2;
    }

    public void setBfrnmkn2(String pBfrnmkn2) {
        bfrnmkn2 = pBfrnmkn2;
    }

    public String getBfrnmkj2() {
        return bfrnmkj2;
    }

    public void setBfrnmkj2(String pBfrnmkj2) {
        bfrnmkj2 = pBfrnmkj2;
    }

    public BizDate getBfrseiymd2() {
        return bfrseiymd2;
    }

    public void setBfrseiymd2(BizDate pBfrseiymd2) {
        bfrseiymd2 = pBfrseiymd2;
    }

    public C_Seibetu getBfrsei2() {
        return bfrsei2;
    }

    public void setBfrsei2(C_Seibetu pBfrsei2) {
        bfrsei2 = pBfrsei2;
    }

    public BizDate getBfrKouryokuendymd2() {
        return bfrKouryokuendymd2;
    }

    public void setBfrKouryokuendymd2(BizDate pKouryokuendymd2) {
        bfrKouryokuendymd2 = pKouryokuendymd2;
    }

    public BizDate getBfrSyoriymd3() {
        return bfrSyoriymd3;
    }

    public void setBfrSyoriymd3(BizDate pBfrSyoriymd3) {
        bfrSyoriymd3 = pBfrSyoriymd3;
    }

    public String getSyoriSosikicd3() {
        return syoriSosikicd3;
    }

    public void setSyoriSosikicd3(String pSyoriSosikicd3) {
        syoriSosikicd3 = pSyoriSosikicd3;
    }

    public C_FatcasnsiKbn getBfrfatcasnsikbn3() {
        return bfrfatcasnsikbn3;
    }

    public void setBfrfatcasnsikbn3(C_FatcasnsiKbn pBfrfatcasnsikbn3) {
        bfrfatcasnsikbn3 = pBfrfatcasnsikbn3;
    }

    public C_BikkjnssinfoKbn getBfrbikkjnssinfokbn3() {
        return bfrbikkjnssinfokbn3;
    }

    public void setBfrbikkjnssinfokbn3(C_BikkjnssinfoKbn pBfrbikkjnssinfokbn3) {
        bfrbikkjnssinfokbn3 = pBfrbikkjnssinfokbn3;
    }

    public C_FatcakekKbn getBfrfatcakekkbn3() {
        return bfrfatcakekkbn3;
    }

    public void setBfrfatcakekkbn3(C_FatcakekKbn pBfrfatcakekkbn3) {
        bfrfatcakekkbn3 = pBfrfatcakekkbn3;
    }

    public C_FatcahankeiiKbn getBfrfatcahankeiikbn3() {
        return bfrfatcahankeiikbn3;
    }

    public void setBfrfatcahankeiikbn3(C_FatcahankeiiKbn pBfrfatcahankeiikbn3) {
        bfrfatcahankeiikbn3 = pBfrfatcahankeiikbn3;
    }

    public String getBfrbikknzsyno3() {
        return bfrbikknzsyno3;
    }

    public void setBfrbikknzsyno3(String pBfrbikknzsyno3) {
        bfrbikknzsyno3 = pBfrbikknzsyno3;
    }

    public BizDate getBfrsyomeiymd3() {
        return bfrsyomeiymd3;
    }

    public void setBfrsyomeiymd3(BizDate pBfrsyomeiymd3) {
        bfrsyomeiymd3 = pBfrsyomeiymd3;
    }

    public C_FatcatgKbn getBfrfatcatgkbn3() {
        return bfrfatcatgkbn3;
    }

    public void setBfrfatcatgkbn3(C_FatcatgKbn pBfrfatcatgkbn3) {
        bfrfatcatgkbn3 = pBfrfatcatgkbn3;
    }

    public String getBfrnmkn3() {
        return bfrnmkn3;
    }

    public void setBfrnmkn3(String pBfrnmkn3) {
        bfrnmkn3 = pBfrnmkn3;
    }

    public String getBfrnmkj3() {
        return bfrnmkj3;
    }

    public void setBfrnmkj3(String pBfrnmkj3) {
        bfrnmkj3 = pBfrnmkj3;
    }

    public BizDate getBfrseiymd3() {
        return bfrseiymd3;
    }

    public void setBfrseiymd3(BizDate pBfrseiymd3) {
        bfrseiymd3 = pBfrseiymd3;
    }

    public C_Seibetu getBfrsei3() {
        return bfrsei3;
    }

    public void setBfrsei3(C_Seibetu pBfrsei3) {
        bfrsei3 = pBfrsei3;
    }

    public BizDate getBfrKouryokuendymd3() {
        return bfrKouryokuendymd3;
    }

    public void setBfrKouryokuendymd3(BizDate pKouryokuendymd3) {
        bfrKouryokuendymd3 = pKouryokuendymd3;
    }

    public BizDate getBfrSyoriymd4() {
        return bfrSyoriymd4;
    }

    public void setBfrSyoriymd4(BizDate pBfrSyoriymd4) {
        bfrSyoriymd4 = pBfrSyoriymd4;
    }

    public String getSyoriSosikicd4() {
        return syoriSosikicd4;
    }

    public void setSyoriSosikicd4(String pSyoriSosikicd4) {
        syoriSosikicd4 = pSyoriSosikicd4;
    }

    public C_FatcasnsiKbn getBfrfatcasnsikbn4() {
        return bfrfatcasnsikbn4;
    }

    public void setBfrfatcasnsikbn4(C_FatcasnsiKbn pBfrfatcasnsikbn4) {
        bfrfatcasnsikbn4 = pBfrfatcasnsikbn4;
    }

    public C_BikkjnssinfoKbn getBfrbikkjnssinfokbn4() {
        return bfrbikkjnssinfokbn4;
    }

    public void setBfrbikkjnssinfokbn4(C_BikkjnssinfoKbn pBfrbikkjnssinfokbn4) {
        bfrbikkjnssinfokbn4 = pBfrbikkjnssinfokbn4;
    }

    public C_FatcakekKbn getBfrfatcakekkbn4() {
        return bfrfatcakekkbn4;
    }

    public void setBfrfatcakekkbn4(C_FatcakekKbn pBfrfatcakekkbn4) {
        bfrfatcakekkbn4 = pBfrfatcakekkbn4;
    }

    public C_FatcahankeiiKbn getBfrfatcahankeiikbn4() {
        return bfrfatcahankeiikbn4;
    }

    public void setBfrfatcahankeiikbn4(C_FatcahankeiiKbn pBfrfatcahankeiikbn4) {
        bfrfatcahankeiikbn4 = pBfrfatcahankeiikbn4;
    }

    public String getBfrbikknzsyno4() {
        return bfrbikknzsyno4;
    }

    public void setBfrbikknzsyno4(String pBfrbikknzsyno4) {
        bfrbikknzsyno4 = pBfrbikknzsyno4;
    }

    public BizDate getBfrsyomeiymd4() {
        return bfrsyomeiymd4;
    }

    public void setBfrsyomeiymd4(BizDate pBfrsyomeiymd4) {
        bfrsyomeiymd4 = pBfrsyomeiymd4;
    }

    public C_FatcatgKbn getBfrfatcatgkbn4() {
        return bfrfatcatgkbn4;
    }

    public void setBfrfatcatgkbn4(C_FatcatgKbn pBfrfatcatgkbn4) {
        bfrfatcatgkbn4 = pBfrfatcatgkbn4;
    }

    public String getBfrnmkn4() {
        return bfrnmkn4;
    }

    public void setBfrnmkn4(String pBfrnmkn4) {
        bfrnmkn4 = pBfrnmkn4;
    }

    public String getBfrnmkj4() {
        return bfrnmkj4;
    }

    public void setBfrnmkj4(String pBfrnmkj4) {
        bfrnmkj4 = pBfrnmkj4;
    }

    public BizDate getBfrseiymd4() {
        return bfrseiymd4;
    }

    public void setBfrseiymd4(BizDate pBfrseiymd4) {
        bfrseiymd4 = pBfrseiymd4;
    }

    public C_Seibetu getBfrsei4() {
        return bfrsei4;
    }

    public void setBfrsei4(C_Seibetu pBfrsei4) {
        bfrsei4 = pBfrsei4;
    }

    public BizDate getBfrKouryokuendymd4() {
        return bfrKouryokuendymd4;
    }

    public void setBfrKouryokuendymd4(BizDate pKouryokuendymd4) {
        bfrKouryokuendymd4 = pKouryokuendymd4;
    }

    public BizDate getBfrSyoriymd5() {
        return bfrSyoriymd5;
    }

    public void setBfrSyoriymd5(BizDate pBfrSyoriymd5) {
        bfrSyoriymd5 = pBfrSyoriymd5;
    }

    public String getSyoriSosikicd5() {
        return syoriSosikicd5;
    }

    public void setSyoriSosikicd5(String pSyoriSosikicd5) {
        syoriSosikicd5 = pSyoriSosikicd5;
    }

    public C_FatcasnsiKbn getBfrfatcasnsikbn5() {
        return bfrfatcasnsikbn5;
    }

    public void setBfrfatcasnsikbn5(C_FatcasnsiKbn pBfrfatcasnsikbn5) {
        bfrfatcasnsikbn5 = pBfrfatcasnsikbn5;
    }

    public C_BikkjnssinfoKbn getBfrbikkjnssinfokbn5() {
        return bfrbikkjnssinfokbn5;
    }

    public void setBfrbikkjnssinfokbn5(C_BikkjnssinfoKbn pBfrbikkjnssinfokbn5) {
        bfrbikkjnssinfokbn5 = pBfrbikkjnssinfokbn5;
    }

    public C_FatcakekKbn getBfrfatcakekkbn5() {
        return bfrfatcakekkbn5;
    }

    public void setBfrfatcakekkbn5(C_FatcakekKbn pBfrfatcakekkbn5) {
        bfrfatcakekkbn5 = pBfrfatcakekkbn5;
    }

    public C_FatcahankeiiKbn getBfrfatcahankeiikbn5() {
        return bfrfatcahankeiikbn5;
    }

    public void setBfrfatcahankeiikbn5(C_FatcahankeiiKbn pBfrfatcahankeiikbn5) {
        bfrfatcahankeiikbn5 = pBfrfatcahankeiikbn5;
    }

    public String getBfrbikknzsyno5() {
        return bfrbikknzsyno5;
    }

    public void setBfrbikknzsyno5(String pBfrbikknzsyno5) {
        bfrbikknzsyno5 = pBfrbikknzsyno5;
    }

    public BizDate getBfrsyomeiymd5() {
        return bfrsyomeiymd5;
    }

    public void setBfrsyomeiymd5(BizDate pBfrsyomeiymd5) {
        bfrsyomeiymd5 = pBfrsyomeiymd5;
    }

    public C_FatcatgKbn getBfrfatcatgkbn5() {
        return bfrfatcatgkbn5;
    }

    public void setBfrfatcatgkbn5(C_FatcatgKbn pBfrfatcatgkbn5) {
        bfrfatcatgkbn5 = pBfrfatcatgkbn5;
    }

    public String getBfrnmkn5() {
        return bfrnmkn5;
    }

    public void setBfrnmkn5(String pBfrnmkn5) {
        bfrnmkn5 = pBfrnmkn5;
    }

    public String getBfrnmkj5() {
        return bfrnmkj5;
    }

    public void setBfrnmkj5(String pBfrnmkj5) {
        bfrnmkj5 = pBfrnmkj5;
    }

    public BizDate getBfrseiymd5() {
        return bfrseiymd5;
    }

    public void setBfrseiymd5(BizDate pBfrseiymd5) {
        bfrseiymd5 = pBfrseiymd5;
    }

    public C_Seibetu getBfrsei5() {
        return bfrsei5;
    }

    public void setBfrsei5(C_Seibetu pBfrsei5) {
        bfrsei5 = pBfrsei5;
    }

    public BizDate getBfrKouryokuendymd5() {
        return bfrKouryokuendymd5;
    }

    public void setBfrKouryokuendymd5(BizDate pKouryokuendymd5) {
        bfrKouryokuendymd5 = pKouryokuendymd5;
    }

    public boolean isFatcaHnkFlg1() {
        return fatcaHnkFlg1;
    }

    public void setFatcaHnkFlg1(boolean fatcaHnkFlg1) {
        this.fatcaHnkFlg1 = fatcaHnkFlg1;
    }

    public boolean isFatcaHnkFlg2() {
        return fatcaHnkFlg2;
    }

    public void setFatcaHnkFlg2(boolean fatcaHnkFlg2) {
        this.fatcaHnkFlg2 = fatcaHnkFlg2;
    }

    public boolean isFatcaHnkFlg3() {
        return fatcaHnkFlg3;
    }

    public void setFatcaHnkFlg3(boolean fatcaHnkFlg3) {
        this.fatcaHnkFlg3 = fatcaHnkFlg3;
    }

    public boolean isFatcaHnkFlg4() {
        return fatcaHnkFlg4;
    }

    public void setFatcaHnkFlg4(boolean fatcaHnkFlg4) {
        this.fatcaHnkFlg4 = fatcaHnkFlg4;
    }

    public boolean isFatcaHnkFlg5() {
        return fatcaHnkFlg5;
    }

    public void setFatcaHnkFlg5(boolean fatcaHnkFlg5) {
        this.fatcaHnkFlg5 = fatcaHnkFlg5;
    }


    public int getBfrAeoiRecordKensuu() {
        return bfrAeoiRecordKensuu;
    }

    public Integer getAeoiRenno1() {
        return aeoiRenno1;
    }

    public void setAeoiRenno1(Integer pAeoiRenno1) {
        aeoiRenno1 = pAeoiRenno1;
    }

    public Integer getAeoiRenno2() {
        return aeoiRenno2;
    }

    public void setAeoiRenno2(Integer pAeoiRenno2) {
        aeoiRenno2 = pAeoiRenno2;
    }

    public Integer getAeoiRenno3() {
        return aeoiRenno3;
    }

    public void setAeoiRenno3(Integer pAeoiRenno3) {
        aeoiRenno3 = pAeoiRenno3;
    }

    public Integer getAeoiRenno4() {
        return aeoiRenno4;
    }

    public void setAeoiRenno4(Integer pAeoiRenno4) {
        aeoiRenno4 = pAeoiRenno4;
    }

    public Integer getAeoiRenno5() {
        return aeoiRenno5;
    }

    public void setAeoiRenno5(Integer pAeoiRenno5) {
        aeoiRenno5 = pAeoiRenno5;
    }

    public void setBfrAeoiRecordKensuu(int pBfrAeoiRecordKensuu) {
        bfrAeoiRecordKensuu = pBfrAeoiRecordKensuu;
    }

    public Integer getBfrAeoiRenno1() {
        return bfrAeoiRenno1;
    }

    public void setBfrAeoiRenno1(Integer pBfrAeoiRenno1) {
        bfrAeoiRenno1 = pBfrAeoiRenno1;
    }

    public Integer getBfrAeoiRenno2() {
        return bfrAeoiRenno2;
    }

    public void setBfrAeoiRenno2(Integer pBfrAeoiRenno2) {
        bfrAeoiRenno2 = pBfrAeoiRenno2;
    }

    public Integer getBfrAeoiRenno3() {
        return bfrAeoiRenno3;
    }

    public void setBfrAeoiRenno3(Integer pBfrAeoiRenno3) {
        bfrAeoiRenno3 = pBfrAeoiRenno3;
    }

    public Integer getBfrAeoiRenno4() {
        return bfrAeoiRenno4;
    }

    public void setBfrAeoiRenno4(Integer pBfrAeoiRenno4) {
        bfrAeoiRenno4 = pBfrAeoiRenno4;
    }

    public Integer getBfrAeoiRenno5() {
        return bfrAeoiRenno5;
    }

    public void setBfrAeoiRenno5(Integer pBfrAeoiRenno5) {
        bfrAeoiRenno5 = pBfrAeoiRenno5;
    }

    public boolean getBfrAeoiSakujyo1() {
        return bfrAeoiSakujyo1;
    }

    public void setBfrAeoiSakujyo1(boolean pBfrAeoiSakujyo1) {
        bfrAeoiSakujyo1 = pBfrAeoiSakujyo1;
    }

    public BizDate getBfrAeoiSyoriymd1() {
        return bfrAeoiSyoriymd1;
    }

    public void setBfrAeoiSyoriymd1(BizDate pBfrAeoiSyoriymd1) {
        bfrAeoiSyoriymd1 = pBfrAeoiSyoriymd1;
    }

    public String getBfrAeoiSyorisosikicd1() {
        return bfrAeoiSyorisosikicd1;
    }

    public void setBfrAeoiSyorisosikicd1(String pBfrAeoiSyorisosikicd1) {
        bfrAeoiSyorisosikicd1 = pBfrAeoiSyorisosikicd1;
    }

    public C_AeoiKekkaKbn getBfrAeoiKekkakbn1() {
        return bfrAeoiKekkakbn1;
    }

    public void setBfrAeoiKekkakbn1(C_AeoiKekkaKbn pBfrAeoiKekkakbn1) {
        bfrAeoiKekkakbn1 = pBfrAeoiKekkakbn1;
    }

    public C_AeoiSyoriKbn getBfrAeoiSyorikbn1() {
        return bfrAeoiSyorikbn1;
    }

    public void setBfrAeoiSyorikbn1(C_AeoiSyoriKbn pBfrAeoiSyorikbn1) {
        bfrAeoiSyorikbn1 = pBfrAeoiSyorikbn1;
    }

    public C_AeoiTaisyousyaKbn getBfrAeoiTaisyousyakbn1() {
        return bfrAeoiTaisyousyakbn1;
    }

    public void setBfrAeoiTaisyousyakbn1(C_AeoiTaisyousyaKbn pBfrAeoiTaisyousyakbn1) {
        bfrAeoiTaisyousyakbn1 = pBfrAeoiTaisyousyakbn1;
    }

    public C_AeoiHoujinSyuruiKbn getBfrAeoiHoujinsyuruikbn1() {
        return bfrAeoiHoujinsyuruikbn1;
    }

    public void setBfrAeoiHoujinsyuruikbn1(C_AeoiHoujinSyuruiKbn pBfrAeoiHoujinsyuruikbn1) {
        bfrAeoiHoujinsyuruikbn1 = pBfrAeoiHoujinsyuruikbn1;
    }

    public BizDate getBfrAeoiKouryokusttymd1() {
        return bfrAeoiKouryokusttymd1;
    }

    public void setBfrAeoiKouryokusttymd1(BizDate pBfrAeoiKouryokusttymd1) {
        bfrAeoiKouryokusttymd1 = pBfrAeoiKouryokusttymd1;
    }

    public BizDate getBfrAeoiKouryokuendymd1() {
        return bfrAeoiKouryokuendymd1;
    }

    public void setBfrAeoiKouryokuendymd1(BizDate pBfrAeoiKouryokuendymd1) {
        bfrAeoiKouryokuendymd1 = pBfrAeoiKouryokuendymd1;
    }

    public boolean getBfrAeoiSakujyo2() {
        return bfrAeoiSakujyo2;
    }

    public void setBfrAeoiSakujyo2(boolean pBfrAeoiSakujyo2) {
        bfrAeoiSakujyo2 = pBfrAeoiSakujyo2;
    }

    public BizDate getBfrAeoiSyoriymd2() {
        return bfrAeoiSyoriymd2;
    }

    public void setBfrAeoiSyoriymd2(BizDate pBfrAeoiSyoriymd2) {
        bfrAeoiSyoriymd2 = pBfrAeoiSyoriymd2;
    }

    public String getBfrAeoiSyorisosikicd2() {
        return bfrAeoiSyorisosikicd2;
    }

    public void setBfrAeoiSyorisosikicd2(String pBfrAeoiSyorisosikicd2) {
        bfrAeoiSyorisosikicd2 = pBfrAeoiSyorisosikicd2;
    }

    public C_AeoiKekkaKbn getBfrAeoiKekkakbn2() {
        return bfrAeoiKekkakbn2;
    }

    public void setBfrAeoiKekkakbn2(C_AeoiKekkaKbn pBfrAeoiKekkakbn2) {
        bfrAeoiKekkakbn2 = pBfrAeoiKekkakbn2;
    }

    public C_AeoiSyoriKbn getBfrAeoiSyorikbn2() {
        return bfrAeoiSyorikbn2;
    }

    public void setBfrAeoiSyorikbn2(C_AeoiSyoriKbn pBfrAeoiSyorikbn2) {
        bfrAeoiSyorikbn2 = pBfrAeoiSyorikbn2;
    }

    public C_AeoiTaisyousyaKbn getBfrAeoiTaisyousyakbn2() {
        return bfrAeoiTaisyousyakbn2;
    }

    public void setBfrAeoiTaisyousyakbn2(C_AeoiTaisyousyaKbn pBfrAeoiTaisyousyakbn2) {
        bfrAeoiTaisyousyakbn2 = pBfrAeoiTaisyousyakbn2;
    }

    public C_AeoiHoujinSyuruiKbn getBfrAeoiHoujinsyuruikbn2() {
        return bfrAeoiHoujinsyuruikbn2;
    }

    public void setBfrAeoiHoujinsyuruikbn2(C_AeoiHoujinSyuruiKbn pBfrAeoiHoujinsyuruikbn2) {
        bfrAeoiHoujinsyuruikbn2 = pBfrAeoiHoujinsyuruikbn2;
    }

    public BizDate getBfrAeoiKouryokusttymd2() {
        return bfrAeoiKouryokusttymd2;
    }

    public void setBfrAeoiKouryokusttymd2(BizDate pBfrAeoiKouryokusttymd2) {
        bfrAeoiKouryokusttymd2 = pBfrAeoiKouryokusttymd2;
    }

    public BizDate getBfrAeoiKouryokuendymd2() {
        return bfrAeoiKouryokuendymd2;
    }

    public void setBfrAeoiKouryokuendymd2(BizDate pBfrAeoiKouryokuendymd2) {
        bfrAeoiKouryokuendymd2 = pBfrAeoiKouryokuendymd2;
    }

    public boolean getBfrAeoiSakujyo3() {
        return bfrAeoiSakujyo3;
    }

    public void setBfrAeoiSakujyo3(boolean pBfrAeoiSakujyo3) {
        bfrAeoiSakujyo3 = pBfrAeoiSakujyo3;
    }

    public BizDate getBfrAeoiSyoriymd3() {
        return bfrAeoiSyoriymd3;
    }

    public void setBfrAeoiSyoriymd3(BizDate pBfrAeoiSyoriymd3) {
        bfrAeoiSyoriymd3 = pBfrAeoiSyoriymd3;
    }

    public String getBfrAeoiSyorisosikicd3() {
        return bfrAeoiSyorisosikicd3;
    }

    public void setBfrAeoiSyorisosikicd3(String pBfrAeoiSyorisosikicd3) {
        bfrAeoiSyorisosikicd3 = pBfrAeoiSyorisosikicd3;
    }

    public C_AeoiKekkaKbn getBfrAeoiKekkakbn3() {
        return bfrAeoiKekkakbn3;
    }

    public void setBfrAeoiKekkakbn3(C_AeoiKekkaKbn pBfrAeoiKekkakbn3) {
        bfrAeoiKekkakbn3 = pBfrAeoiKekkakbn3;
    }

    public C_AeoiSyoriKbn getBfrAeoiSyorikbn3() {
        return bfrAeoiSyorikbn3;
    }

    public void setBfrAeoiSyorikbn3(C_AeoiSyoriKbn pBfrAeoiSyorikbn3) {
        bfrAeoiSyorikbn3 = pBfrAeoiSyorikbn3;
    }

    public C_AeoiTaisyousyaKbn getBfrAeoiTaisyousyakbn3() {
        return bfrAeoiTaisyousyakbn3;
    }

    public void setBfrAeoiTaisyousyakbn3(C_AeoiTaisyousyaKbn pBfrAeoiTaisyousyakbn3) {
        bfrAeoiTaisyousyakbn3 = pBfrAeoiTaisyousyakbn3;
    }

    public C_AeoiHoujinSyuruiKbn getBfrAeoiHoujinsyuruikbn3() {
        return bfrAeoiHoujinsyuruikbn3;
    }

    public void setBfrAeoiHoujinsyuruikbn3(C_AeoiHoujinSyuruiKbn pBfrAeoiHoujinsyuruikbn3) {
        bfrAeoiHoujinsyuruikbn3 = pBfrAeoiHoujinsyuruikbn3;
    }

    public BizDate getBfrAeoiKouryokusttymd3() {
        return bfrAeoiKouryokusttymd3;
    }

    public void setBfrAeoiKouryokusttymd3(BizDate pBfrAeoiKouryokusttymd3) {
        bfrAeoiKouryokusttymd3 = pBfrAeoiKouryokusttymd3;
    }

    public BizDate getBfrAeoiKouryokuendymd3() {
        return bfrAeoiKouryokuendymd3;
    }

    public void setBfrAeoiKouryokuendymd3(BizDate pBfrAeoiKouryokuendymd3) {
        bfrAeoiKouryokuendymd3 = pBfrAeoiKouryokuendymd3;
    }

    public boolean getBfrAeoiSakujyo4() {
        return bfrAeoiSakujyo4;
    }

    public void setBfrAeoiSakujyo4(boolean pBfrAeoiSakujyo4) {
        bfrAeoiSakujyo4 = pBfrAeoiSakujyo4;
    }

    public BizDate getBfrAeoiSyoriymd4() {
        return bfrAeoiSyoriymd4;
    }

    public void setBfrAeoiSyoriymd4(BizDate pBfrAeoiSyoriymd4) {
        bfrAeoiSyoriymd4 = pBfrAeoiSyoriymd4;
    }

    public String getBfrAeoiSyorisosikicd4() {
        return bfrAeoiSyorisosikicd4;
    }

    public void setBfrAeoiSyorisosikicd4(String pBfrAeoiSyorisosikicd4) {
        bfrAeoiSyorisosikicd4 = pBfrAeoiSyorisosikicd4;
    }

    public C_AeoiKekkaKbn getBfrAeoiKekkakbn4() {
        return bfrAeoiKekkakbn4;
    }

    public void setBfrAeoiKekkakbn4(C_AeoiKekkaKbn pBfrAeoiKekkakbn4) {
        bfrAeoiKekkakbn4 = pBfrAeoiKekkakbn4;
    }

    public C_AeoiSyoriKbn getBfrAeoiSyorikbn4() {
        return bfrAeoiSyorikbn4;
    }

    public void setBfrAeoiSyorikbn4(C_AeoiSyoriKbn pBfrAeoiSyorikbn4) {
        bfrAeoiSyorikbn4 = pBfrAeoiSyorikbn4;
    }

    public C_AeoiTaisyousyaKbn getBfrAeoiTaisyousyakbn4() {
        return bfrAeoiTaisyousyakbn4;
    }

    public void setBfrAeoiTaisyousyakbn4(C_AeoiTaisyousyaKbn pBfrAeoiTaisyousyakbn4) {
        bfrAeoiTaisyousyakbn4 = pBfrAeoiTaisyousyakbn4;
    }

    public C_AeoiHoujinSyuruiKbn getBfrAeoiHoujinsyuruikbn4() {
        return bfrAeoiHoujinsyuruikbn4;
    }

    public void setBfrAeoiHoujinsyuruikbn4(C_AeoiHoujinSyuruiKbn pBfrAeoiHoujinsyuruikbn4) {
        bfrAeoiHoujinsyuruikbn4 = pBfrAeoiHoujinsyuruikbn4;
    }

    public BizDate getBfrAeoiKouryokusttymd4() {
        return bfrAeoiKouryokusttymd4;
    }

    public void setBfrAeoiKouryokusttymd4(BizDate pBfrAeoiKouryokusttymd4) {
        bfrAeoiKouryokusttymd4 = pBfrAeoiKouryokusttymd4;
    }

    public BizDate getBfrAeoiKouryokuendymd4() {
        return bfrAeoiKouryokuendymd4;
    }

    public void setBfrAeoiKouryokuendymd4(BizDate pBfrAeoiKouryokuendymd4) {
        bfrAeoiKouryokuendymd4 = pBfrAeoiKouryokuendymd4;
    }

    public boolean getBfrAeoiSakujyo5() {
        return bfrAeoiSakujyo5;
    }

    public void setBfrAeoiSakujyo5(boolean pBfrAeoiSakujyo5) {
        bfrAeoiSakujyo5 = pBfrAeoiSakujyo5;
    }

    public BizDate getBfrAeoiSyoriymd5() {
        return bfrAeoiSyoriymd5;
    }

    public void setBfrAeoiSyoriymd5(BizDate pBfrAeoiSyoriymd5) {
        bfrAeoiSyoriymd5 = pBfrAeoiSyoriymd5;
    }

    public String getBfrAeoiSyorisosikicd5() {
        return bfrAeoiSyorisosikicd5;
    }

    public void setBfrAeoiSyorisosikicd5(String pBfrAeoiSyorisosikicd5) {
        bfrAeoiSyorisosikicd5 = pBfrAeoiSyorisosikicd5;
    }

    public C_AeoiKekkaKbn getBfrAeoiKekkakbn5() {
        return bfrAeoiKekkakbn5;
    }

    public void setBfrAeoiKekkakbn5(C_AeoiKekkaKbn pBfrAeoiKekkakbn5) {
        bfrAeoiKekkakbn5 = pBfrAeoiKekkakbn5;
    }

    public C_AeoiSyoriKbn getBfrAeoiSyorikbn5() {
        return bfrAeoiSyorikbn5;
    }

    public void setBfrAeoiSyorikbn5(C_AeoiSyoriKbn pBfrAeoiSyorikbn5) {
        bfrAeoiSyorikbn5 = pBfrAeoiSyorikbn5;
    }

    public C_AeoiTaisyousyaKbn getBfrAeoiTaisyousyakbn5() {
        return bfrAeoiTaisyousyakbn5;
    }

    public void setBfrAeoiTaisyousyakbn5(C_AeoiTaisyousyaKbn pBfrAeoiTaisyousyakbn5) {
        bfrAeoiTaisyousyakbn5 = pBfrAeoiTaisyousyakbn5;
    }

    public C_AeoiHoujinSyuruiKbn getBfrAeoiHoujinsyuruikbn5() {
        return bfrAeoiHoujinsyuruikbn5;
    }

    public void setBfrAeoiHoujinsyuruikbn5(C_AeoiHoujinSyuruiKbn pBfrAeoiHoujinsyuruikbn5) {
        bfrAeoiHoujinsyuruikbn5 = pBfrAeoiHoujinsyuruikbn5;
    }

    public BizDate getBfrAeoiKouryokusttymd5() {
        return bfrAeoiKouryokusttymd5;
    }

    public void setBfrAeoiKouryokusttymd5(BizDate pBfrAeoiKouryokusttymd5) {
        bfrAeoiKouryokusttymd5 = pBfrAeoiKouryokusttymd5;
    }

    public BizDate getBfrAeoiKouryokuendymd5() {
        return bfrAeoiKouryokuendymd5;
    }

    public void setBfrAeoiKouryokuendymd5(BizDate pBfrAeoiKouryokuendymd5) {
        bfrAeoiKouryokuendymd5 = pBfrAeoiKouryokuendymd5;
    }


    public boolean isAeoiHnkFlg1() {
        return aeoiHnkFlg1;
    }

    public void setAeoiHnkFlg1(boolean aeoiHnkFlg1) {
        this.aeoiHnkFlg1 = aeoiHnkFlg1;
    }

    public boolean isAeoiHnkFlg2() {
        return aeoiHnkFlg2;
    }

    public void setAeoiHnkFlg2(boolean aeoiHnkFlg2) {
        this.aeoiHnkFlg2 = aeoiHnkFlg2;
    }

    public boolean isAeoiHnkFlg3() {
        return aeoiHnkFlg3;
    }

    public void setAeoiHnkFlg3(boolean aeoiHnkFlg3) {
        this.aeoiHnkFlg3 = aeoiHnkFlg3;
    }

    public boolean isAeoiHnkFlg4() {
        return aeoiHnkFlg4;
    }

    public void setAeoiHnkFlg4(boolean aeoiHnkFlg4) {
        this.aeoiHnkFlg4 = aeoiHnkFlg4;
    }

    public boolean isAeoiHnkFlg5() {
        return aeoiHnkFlg5;
    }

    public void setAeoiHnkFlg5(boolean aeoiHnkFlg5) {
        this.aeoiHnkFlg5 = aeoiHnkFlg5;
    }

    public C_UmuKbn getMosuktymdhkumu() {
        return mosuktymdhkumu;
    }

    public void setMosuktymdhkumu(C_UmuKbn pMosuktymdhkumu) {
        mosuktymdhkumu = pMosuktymdhkumu;
    }

    public String getHhknyno() {
        return hhknyno;
    }

    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    public String getHhknadr4kj() {
        return hhknadr4kj;
    }

    public void setHhknadr4kj(String pHhknadr4kj) {
        hhknadr4kj = pHhknadr4kj;
    }

    public String getHhkntelno() {
        return hhkntelno;
    }

    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuList) {

        List<KikeiyakuInfoDataSourceBean> kikeiyakuList = Lists.newArrayList();

        for (KikeiyakuInfoDataSourceBeanCommonParam beanPram : pKikeiyakuList) {
            kikeiyakuList.add((KikeiyakuInfoDataSourceBean) beanPram);
        }
        super.setKikeiyakuInfo(kikeiyakuList);
    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {
        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(
        List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiList) {

        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaiList = Lists.newArrayList();

        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pNenkinsiharaiList) {
            nenkinsiharaiList.add((NenkinsiharaiInfoDataSourceBean) beanPram);
        }
        super.setNenkinsiharaiInfo(nenkinsiharaiList);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(
        List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuList) {

        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuList = Lists.newArrayList();

        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanPram : pPalkikeiyakuList) {
            palkikeiyakuList.add((PalkikeiyakuInfoDataSourceBean) beanPram);
        }
        super.setPalkikeiyakuInfo(palkikeiyakuList);
    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {
        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(
        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalnenkinsiharaiList) {

        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiList = Lists.newArrayList();

        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pPalnenkinsiharaiList) {
            palnenkinsiharaiList.add((PalnenkinsiharaiInfoDataSourceBean) beanPram);
        }
        super.setPalnenkinsiharaiInfo(palnenkinsiharaiList);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiList) {

        List<PalsueokiInfoDataSourceBean> palsueokiList = Lists.newArrayList();

        for (PalsueokiInfoDataSourceBeanCommonParam beanPram : pPalsueokiList) {
            palsueokiList.add((PalsueokiInfoDataSourceBean) beanPram);
        }
        super.setPalsueokiInfo(palsueokiList);
    }

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @Override
    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        warningMessageIdList = pWarningMessageIdList;
    }

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageList(List<String> pWarningMessageList) {
        warningMessageList = pWarningMessageList;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    public DataSource<TtdkTyuui1DataSourceBean> getBfrTtdkTyuui1DataSource() {
        return bfrTtdkTyuui1DataSource;
    }

    @Deprecated
    public List<TtdkTyuui1DataSourceBean> getBfrTtdkTyuui1() {
        return bfrTtdkTyuui1DataSource.getDatas();
    }

    public void setBfrTtdkTyuui1(List<TtdkTyuui1DataSourceBean> pBfrTtdkTyuui1) {
        bfrTtdkTyuui1DataSource.setDatas(pBfrTtdkTyuui1);
    }

    public C_UmuKbn getKykdrtkykumu() {
        return kykdrtkykumu;
    }

    public void setKykdrtkykumu(C_UmuKbn pKykdrtkykumu) {
        this.kykdrtkykumu = pKykdrtkykumu;
    }

    public C_KykdrknHtdjytKbn getBrfKykdrknhatudoujyoutai() {
        return brfKykdrknhatudoujyoutai;
    }

    public void setBrfKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pBrfKykdrknhatudoujyoutai) {
        this.brfKykdrknhatudoujyoutai = pBrfKykdrknhatudoujyoutai;
    }

    public C_KykdrDouiYouhiKbn getBrfKykdrdouiyouhi() {
        return brfKykdrdouiyouhi;
    }

    public void setBrfKykdrdouiyouhi(C_KykdrDouiYouhiKbn pBrfKykdrdouiyouhi) {
        this.brfKykdrdouiyouhi = pBrfKykdrdouiyouhi;
    }

    public boolean isKykdrknhatudouHnkFlg() {
        return kykdrknhatudouHnkFlg;
    }

    public void setKykdrknhatudouHnkFlg(boolean pKykdrknhatudouHnkFlg) {
        this.kykdrknhatudouHnkFlg = pKykdrknhatudouHnkFlg;
    }

    public boolean isKykdrdouiyouhiHnkFlg() {
        return kykdrdouiyouhiHnkFlg;
    }

    public void setKykdrdouiyouhiHnkFlg(boolean pKykdrdouiyouhiHnkFlg) {
        this.kykdrdouiyouhiHnkFlg = pKykdrdouiyouhiHnkFlg;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

    public C_UmuKbn getTyouhyoumukbn() {
        return tyouhyoumukbn;
    }

    public void setTyouhyoumukbn(C_UmuKbn pTyouhyoumukbn) {
        tyouhyoumukbn = pTyouhyoumukbn;
    }

}
