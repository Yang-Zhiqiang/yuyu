package yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.hozen.khview.viewhosyou.ViewHosyouUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewsonotatk.ViewSonotaTkUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHosyouExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSonotaTkExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TbktInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 目標額到達時円建変更受付 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhMkhgkTttYendtHnkUktkUiBean extends GenKhMkhgkTttYendtHnkUktkUiBean implements ViewKihonUiBeanParam,
ViewKeiyakusyaUiBeanParam, ViewTuusinsakiUiBeanParam, ViewTetudukityuuiUiBeanParam, ViewBetukykUiBeanParam,
ViewHihokensyaUiBeanParam, ViewHosyouUiBeanParam, ViewSonotaTkUiBeanParam, CheckYuukouJyoutaiExecUiBeanParam,
SetBetukykExecUiBeanParam, SetToriatukaiTyuuiExecUiBeanParam, SetTetudukityuuiExecUiBeanParam,
SetKeiyakusyaExecUiBeanParam, SetTuusinsakiExecUiBeanParam, SetHihokensyaExecUiBeanParam,
SetHosyouExecUiBeanParam, SetSonotaTkExecUiBeanParam, SetKihonExecUiBeanParam {
    private static final long serialVersionUID = 1L;

    public KhMkhgkTttYendtHnkUktkUiBean() {
    }

    @Inject
    private IT_KykKihon kykKihon;

    private String syono;

    private BizDate dispsyoukaiymdfrom;

    private BizDate dispsyoukaiymdto;

    private List<C_HnskariyuuKbn> hnskariyuuList = new ArrayList<>();

    private C_UmuKbn nensbhnkumu;

    private BizDate nenseihnkymd;

    private String yendtgosyouhncd;

    private Integer yendtgosyouhnsdno;

    private String yendtgoryouritusdno;

    private BizNumber yendthnkyoteiriritu;

    private BizDate yendthnkymd;

    private BizCurrency yendthnkkaiyakuhrgaika;

    private BizCurrency yendthnkkaiyakuhryen;

    private List<String> warningMessageIdList = new ArrayList<>();

    private List<String> warningMessageList = new ArrayList<>();

    private BizNumber kawaserate;

    private BizNumber tumitateriritu;

    private int syohinHanteiKbn;

    private BizCurrency yendthnkkjnkg;

    private Integer targettkmokuhyouti;

    private BizCurrency mkhgk;

    private BizNumber sjkkktyouseiyouriritu;

    private BizCurrency kaiyakukjgk;

    private BizNumber kaiyakukoujyoritu;

    private BizCurrency ptmttkngk;

    private C_UmuKbn kaiyakukoujyoritutekiumu;

    private BizCurrency yendthnkSibous;

    private C_UmuKbn vhsyusyunkhknumu;

    private C_UmuKbn vhsyusyugannyukyhumu;

    private C_KhnkyhkgbairituKbn vhsyusyukhnkyhkgbairitukbn;

    private C_UmuKbn vhsyusyusndkyhkinshrskgnumu;

    private C_UmuKbn vhsyusyuhghkumu;

    private C_UmuKbn vhsyusyunextkosumu;

    private String vhsyudisptksyouhncd1;

    private String vhsyudisptksyouhncd2;

    private String vhsyudisptksyouhncd3;

    private String vhsyudisptksyouhncd4;

    private String vhsyudisptksyouhncd5;

    private String vhsyudisptksyouhncd6;

    private String vhsyudisptksyouhncd7;

    private String vhsyudisptksyouhncd8;

    private String vhsyudisptksyouhncd9;

    private String vhsyudisptksyouhncd10;

    private C_UmuKbn vhsyudisptknkhknumu1;

    private C_UmuKbn vhsyudisptknkhknumu2;

    private C_UmuKbn vhsyudisptknkhknumu3;

    private C_UmuKbn vhsyudisptknkhknumu4;

    private C_UmuKbn vhsyudisptknkhknumu5;

    private C_UmuKbn vhsyudisptknkhknumu6;

    private C_UmuKbn vhsyudisptknkhknumu7;

    private C_UmuKbn vhsyudisptknkhknumu8;

    private C_UmuKbn vhsyudisptknkhknumu9;

    private C_UmuKbn vhsyudisptknkhknumu10;

    private C_UmuKbn vhsyuddisptkhghkumu1;

    private C_UmuKbn vhsyuddisptkhghkumu2;

    private C_UmuKbn vhsyuddisptkhghkumu3;

    private C_UmuKbn vhsyuddisptkhghkumu4;

    private C_UmuKbn vhsyuddisptkhghkumu5;

    private C_UmuKbn vhsyuddisptkhghkumu6;

    private C_UmuKbn vhsyuddisptkhghkumu7;

    private C_UmuKbn vhsyuddisptkhghkumu8;

    private C_UmuKbn vhsyuddisptkhghkumu9;

    private C_UmuKbn vhsyuddisptkhghkumu10;

    private C_UmuKbn vhsyudisptkgannyukyhumu1;

    private C_UmuKbn vhsyudisptkgannyukyhumu2;

    private C_UmuKbn vhsyudisptkgannyukyhumu3;

    private C_UmuKbn vhsyudisptkgannyukyhumu4;

    private C_UmuKbn vhsyudisptkgannyukyhumu5;

    private C_UmuKbn vhsyudisptkgannyukyhumu6;

    private C_UmuKbn vhsyudisptkgannyukyhumu7;

    private C_UmuKbn vhsyudisptkgannyukyhumu8;

    private C_UmuKbn vhsyudisptkgannyukyhumu9;

    private C_UmuKbn vhsyudisptkgannyukyhumu10;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu1;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu2;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu3;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu4;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu5;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu6;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu7;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu8;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu9;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu10;

    private C_UmuKbn vhsyudisptknextkosumu1;

    private C_UmuKbn vhsyudisptknextkosumu2;

    private C_UmuKbn vhsyudisptknextkosumu3;

    private C_UmuKbn vhsyudisptknextkosumu4;

    private C_UmuKbn vhsyudisptknextkosumu5;

    private C_UmuKbn vhsyudisptknextkosumu6;

    private C_UmuKbn vhsyudisptknextkosumu7;

    private C_UmuKbn vhsyudisptknextkosumu8;

    private C_UmuKbn vhsyudisptknextkosumu9;

    private C_UmuKbn vhsyudisptknextkosumu10;

    private C_UmuKbn vhsyusyutsnshrgndhjumu;

    private BizCurrency vhsyudispsyutsnshrgndgk;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu1;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu2;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu3;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu4;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu5;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu6;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu7;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu8;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu9;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu10;

    private BizCurrency vhsyudisptktsnshrgndgk1;

    private BizCurrency vhsyudisptktsnshrgndgk2;

    private BizCurrency vhsyudisptktsnshrgndgk3;

    private BizCurrency vhsyudisptktsnshrgndgk4;

    private BizCurrency vhsyudisptktsnshrgndgk5;

    private BizCurrency vhsyudisptktsnshrgndgk6;

    private BizCurrency vhsyudisptktsnshrgndgk7;

    private BizCurrency vhsyudisptktsnshrgndgk8;

    private BizCurrency vhsyudisptktsnshrgndgk9;

    private BizCurrency vhsyudisptktsnshrgndgk10;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn1;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn2;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn3;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn4;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn5;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn6;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn7;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn8;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn9;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn10;

    private C_UmuKbn vhsyunstkhukaumukbn;

    private C_UmuKbn vhsyudai1hknkknsbsyokuseiumu;

    private C_UmuKbn vhsyusgsbhsyumu;

    private C_HknKknKbn vhsyuhknKknKbn;

    private int vhsyusyohinhanteikbn;

    private C_UmuKbn vhsyumvatekiumu;

    private C_UmuKbn vhsyusbhkuktumu;

    private C_UmuKbn vhsyusbkyuuhukinuktumu;

    private BizDate vhsyuyendthnkymd;

    private BizDate vhsyusyunkshrstartymd;

    private BizCurrency vhsyuteiritutmttkngk;

    private BizCurrency vhsyusisuurendoutmttkngk;

    private BizCurrency vhsyugenzaitmttkngk;

    private BizNumber vhsyusisuurendourate;

    private BizNumber vhsyuteiritutmttrate;

    private String vhsyusisuunm;

    private BizNumber vhsyusetteibairitu;

    private BizNumber vhsyuyoteiriritu;

    private BizNumber vhsyutumitateriritu;

    private BizNumber vhsyukyksjkkktyouseiriritu;

    private BizNumber vhsyuskisjkkktyouseiriritu;

    private C_YendthnkJyoutaiKbn vhsyuyendthnkjyoutaikbn;

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    public BizDate getDispsyoukaiymdfrom() {
        return dispsyoukaiymdfrom;
    }

    public void setDispsyoukaiymdfrom(BizDate pDispsyoukaiymdfrom) {
        dispsyoukaiymdfrom = pDispsyoukaiymdfrom;
    }

    public BizDate getDispsyoukaiymdto() {
        return dispsyoukaiymdto;
    }

    public void setDispsyoukaiymdto(BizDate pDispsyoukaiymdto) {
        dispsyoukaiymdto = pDispsyoukaiymdto;
    }

    public List<C_HnskariyuuKbn> getHnskariyuuList() {
        return hnskariyuuList;
    }

    public void setHnskariyuuList(List<C_HnskariyuuKbn> pHnskariyuuList) {
        hnskariyuuList = pHnskariyuuList;
    }

    public C_UmuKbn getNensbhnkumu() {
        return nensbhnkumu;
    }

    public void setNensbhnkumu(C_UmuKbn pNensbhnkumu) {
        nensbhnkumu = pNensbhnkumu;
    }

    public BizDate getNenseihnkymd() {
        return nenseihnkymd;
    }

    public void setNenseihnkymd(BizDate pNenseihnkymd) {
        nenseihnkymd = pNenseihnkymd;
    }

    public String getYendtgosyouhncd() {
        return yendtgosyouhncd;
    }

    public void setYendtgosyouhncd(String pYendtgosyouhncd) {
        yendtgosyouhncd = pYendtgosyouhncd;
    }

    public Integer getYendtgosyouhnsdno() {
        return yendtgosyouhnsdno;
    }

    public void setYendtgosyouhnsdno(Integer pYendtgosyouhnsdno) {
        yendtgosyouhnsdno = pYendtgosyouhnsdno;
    }

    public String getYendtgoryouritusdno() {
        return yendtgoryouritusdno;
    }

    public void setYendtgoryouritusdno(String pYendtgoryouritusdno) {
        yendtgoryouritusdno = pYendtgoryouritusdno;
    }

    public BizNumber getYendthnkyoteiriritu() {
        return yendthnkyoteiriritu;
    }

    public void setYendthnkyoteiriritu(BizNumber pYendthnkyoteiriritu) {
        yendthnkyoteiriritu = pYendthnkyoteiriritu;
    }

    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    public BizCurrency getYendthnkkaiyakuhrgaika() {
        return yendthnkkaiyakuhrgaika;
    }

    public void setYendthnkkaiyakuhrgaika(BizCurrency pYendthnkkaiyakuhrgaika) {
        yendthnkkaiyakuhrgaika = pYendthnkkaiyakuhrgaika;
    }

    public BizCurrency getYendthnkkaiyakuhryen() {
        return yendthnkkaiyakuhryen;
    }

    public void setYendthnkkaiyakuhryen(BizCurrency pYendthnkkaiyakuhryen) {
        yendthnkkaiyakuhryen = pYendthnkkaiyakuhryen;
    }

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        warningMessageIdList = pWarningMessageIdList;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public void setWarningMessageList(List<String> pWarningMessageList) {
        warningMessageList = pWarningMessageList;
    }

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    public void setTumitateriritu(BizNumber pTumitateriritu) {
        tumitateriritu = pTumitateriritu;
    }

    public int getSyohinHanteiKbn() {
        return syohinHanteiKbn;
    }

    public void setSyohinHanteiKbn(int pSyohinHanteiKbn) {
        syohinHanteiKbn = pSyohinHanteiKbn;
    }

    public BizCurrency getYendthnkkjnkg() {
        return yendthnkkjnkg;
    }

    public void setYendthnkkjnkg(BizCurrency pYendthnkkjnkg) {
        yendthnkkjnkg = pYendthnkkjnkg;
    }

    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    public BizCurrency getMkhgk() {
        return mkhgk;
    }

    public void setMkhgk(BizCurrency pMkhgk) {
        mkhgk = pMkhgk;
    }

    public BizNumber getSjkkktyouseiyouriritu() {
        return sjkkktyouseiyouriritu;
    }

    public void setSjkkktyouseiyouriritu(BizNumber pSjkkktyouseiyouriritu) {
        sjkkktyouseiyouriritu = pSjkkktyouseiyouriritu;
    }

    public BizCurrency getKaiyakukjgk() {
        return kaiyakukjgk;
    }

    public void setKaiyakukjgk(BizCurrency pKaiyakukjgk) {
        kaiyakukjgk = pKaiyakukjgk;
    }

    public BizNumber getKaiyakukoujyoritu() {
        return kaiyakukoujyoritu;
    }

    public void setKaiyakukoujyoritu(BizNumber pKaiyakukoujyoritu) {
        kaiyakukoujyoritu = pKaiyakukoujyoritu;
    }

    public BizCurrency getPtmttkngk() {
        return ptmttkngk;
    }

    public void setPtmttkngk(BizCurrency pPtmttkngk) {
        ptmttkngk = pPtmttkngk;
    }

    public C_UmuKbn getKaiyakukoujyoritutekiumu() {
        return kaiyakukoujyoritutekiumu;
    }

    public void setKaiyakukoujyoritutekiumu(C_UmuKbn pKaiyakukoujyoritutekiumu) {
        kaiyakukoujyoritutekiumu = pKaiyakukoujyoritutekiumu;
    }

    public BizCurrency getYendthnkSibous() {
        return yendthnkSibous;
    }

    public void setYendthnkSibous(BizCurrency pYendthnkSibous) {
        yendthnkSibous = pYendthnkSibous;
    }

    @Override
    public C_UmuKbn getVhsyusyunkhknumu() {
        return vhsyusyunkhknumu;
    }

    @Override
    public void setVhsyusyunkhknumu(C_UmuKbn pVhsyusyunkhknumu) {
        vhsyusyunkhknumu = pVhsyusyunkhknumu;
    }

    @Override
    public C_UmuKbn getVhsyusyugannyukyhumu() {
        return vhsyusyugannyukyhumu;
    }

    @Override
    public void setVhsyusyugannyukyhumu(C_UmuKbn pVhsyusyugannyukyhumu) {
        vhsyusyugannyukyhumu = pVhsyusyugannyukyhumu;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyusyukhnkyhkgbairitukbn() {
        return vhsyusyukhnkyhkgbairitukbn;
    }

    @Override
    public void setVhsyusyukhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pVhsyusyukhnkyhkgbairitukbn) {
        vhsyusyukhnkyhkgbairitukbn = pVhsyusyukhnkyhkgbairitukbn;
    }

    @Override
    public C_UmuKbn getVhsyusyusndkyhkinshrskgnumu() {
        return vhsyusyusndkyhkinshrskgnumu;
    }

    @Override
    public void setVhsyusyusndkyhkinshrskgnumu(C_UmuKbn pVhsyusyusndkyhkinshrskgnumu) {
        vhsyusyusndkyhkinshrskgnumu = pVhsyusyusndkyhkinshrskgnumu;
    }

    @Override
    public C_UmuKbn getVhsyusyuhghkumu() {
        return vhsyusyuhghkumu;
    }

    @Override
    public void setVhsyusyuhghkumu(C_UmuKbn pVhsyusyuhghkumu) {
        vhsyusyuhghkumu = pVhsyusyuhghkumu;
    }

    @Override
    public C_UmuKbn getVhsyusyunextkosumu() {
        return vhsyusyunextkosumu;
    }

    @Override
    public void setVhsyusyunextkosumu(C_UmuKbn pVhsyudsyunextkosumu) {
        vhsyusyunextkosumu = pVhsyudsyunextkosumu;
    }

    @Override
    public String getVhsyudisptksyouhncd1() {
        return vhsyudisptksyouhncd1;
    }

    @Override
    public void setVhsyudisptksyouhncd1(String pVhsyudisptksyouhncd1) {
        vhsyudisptksyouhncd1 = pVhsyudisptksyouhncd1;
    }

    @Override
    public String getVhsyudisptksyouhncd2() {
        return vhsyudisptksyouhncd2;
    }

    @Override
    public void setVhsyudisptksyouhncd2(String pVhsyudisptksyouhncd2) {
        vhsyudisptksyouhncd2 = pVhsyudisptksyouhncd2;
    }

    @Override
    public String getVhsyudisptksyouhncd3() {
        return vhsyudisptksyouhncd3;
    }

    @Override
    public void setVhsyudisptksyouhncd3(String pVhsyudisptksyouhncd3) {
        vhsyudisptksyouhncd3 = pVhsyudisptksyouhncd3;
    }

    @Override
    public String getVhsyudisptksyouhncd4() {
        return vhsyudisptksyouhncd4;
    }

    @Override
    public void setVhsyudisptksyouhncd4(String pVhsyudisptksyouhncd4) {
        vhsyudisptksyouhncd4 = pVhsyudisptksyouhncd4;
    }

    @Override
    public String getVhsyudisptksyouhncd5() {
        return vhsyudisptksyouhncd5;
    }

    @Override
    public void setVhsyudisptksyouhncd5(String pVhsyudisptksyouhncd5) {
        vhsyudisptksyouhncd5 = pVhsyudisptksyouhncd5;
    }

    @Override
    public String getVhsyudisptksyouhncd6() {
        return vhsyudisptksyouhncd6;
    }

    @Override
    public void setVhsyudisptksyouhncd6(String pVhsyudisptksyouhncd6) {
        vhsyudisptksyouhncd6 = pVhsyudisptksyouhncd6;
    }

    @Override
    public String getVhsyudisptksyouhncd7() {
        return vhsyudisptksyouhncd7;
    }

    @Override
    public void setVhsyudisptksyouhncd7(String pVhsyudisptksyouhncd7) {
        vhsyudisptksyouhncd7 = pVhsyudisptksyouhncd7;
    }

    @Override
    public String getVhsyudisptksyouhncd8() {
        return vhsyudisptksyouhncd8;
    }

    @Override
    public void setVhsyudisptksyouhncd8(String pVhsyudisptksyouhncd8) {
        vhsyudisptksyouhncd8 = pVhsyudisptksyouhncd8;
    }

    @Override
    public String getVhsyudisptksyouhncd9() {
        return vhsyudisptksyouhncd9;
    }

    @Override
    public void setVhsyudisptksyouhncd9(String pVhsyudisptksyouhncd9) {
        vhsyudisptksyouhncd9 = pVhsyudisptksyouhncd9;
    }

    @Override
    public String getVhsyudisptksyouhncd10() {
        return vhsyudisptksyouhncd10;
    }

    @Override
    public void setVhsyudisptksyouhncd10(String pVhsyudisptksyouhncd10) {
        vhsyudisptksyouhncd10 = pVhsyudisptksyouhncd10;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu1() {
        return vhsyudisptknkhknumu1;
    }

    @Override
    public void setVhsyudisptknkhknumu1(C_UmuKbn pVhsyudisptknkhknumu1) {
        vhsyudisptknkhknumu1 = pVhsyudisptknkhknumu1;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu2() {
        return vhsyudisptknkhknumu2;
    }

    @Override
    public void setVhsyudisptknkhknumu2(C_UmuKbn pVhsyudisptknkhknumu2) {
        vhsyudisptknkhknumu2 = pVhsyudisptknkhknumu2;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu3() {
        return vhsyudisptknkhknumu3;
    }

    @Override
    public void setVhsyudisptknkhknumu3(C_UmuKbn pVhsyudisptknkhknumu3) {
        vhsyudisptknkhknumu3 = pVhsyudisptknkhknumu3;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu4() {
        return vhsyudisptknkhknumu4;
    }

    @Override
    public void setVhsyudisptknkhknumu4(C_UmuKbn pVhsyudisptknkhknumu4) {
        vhsyudisptknkhknumu4 = pVhsyudisptknkhknumu4;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu5() {
        return vhsyudisptknkhknumu5;
    }

    @Override
    public void setVhsyudisptknkhknumu5(C_UmuKbn pVhsyudisptknkhknumu5) {
        vhsyudisptknkhknumu5 = pVhsyudisptknkhknumu5;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu6() {
        return vhsyudisptknkhknumu6;
    }

    @Override
    public void setVhsyudisptknkhknumu6(C_UmuKbn pVhsyudisptknkhknumu6) {
        vhsyudisptknkhknumu6 = pVhsyudisptknkhknumu6;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu7() {
        return vhsyudisptknkhknumu7;
    }

    @Override
    public void setVhsyudisptknkhknumu7(C_UmuKbn pVhsyudisptknkhknumu7) {
        vhsyudisptknkhknumu7 = pVhsyudisptknkhknumu7;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu8() {
        return vhsyudisptknkhknumu8;
    }

    @Override
    public void setVhsyudisptknkhknumu8(C_UmuKbn pVhsyudisptknkhknumu8) {
        vhsyudisptknkhknumu8 = pVhsyudisptknkhknumu8;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu9() {
        return vhsyudisptknkhknumu9;
    }

    @Override
    public void setVhsyudisptknkhknumu9(C_UmuKbn pVhsyudisptknkhknumu9) {
        vhsyudisptknkhknumu9 = pVhsyudisptknkhknumu9;
    }

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu10() {
        return vhsyudisptknkhknumu10;
    }

    @Override
    public void setVhsyudisptknkhknumu10(C_UmuKbn pVhsyudisptknkhknumu10) {
        vhsyudisptknkhknumu10 = pVhsyudisptknkhknumu10;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu1() {
        return vhsyuddisptkhghkumu1;
    }

    @Override
    public void setVhsyudisptkhghkumu1(C_UmuKbn pVhsyudisptkhghkumu1) {
        vhsyuddisptkhghkumu1 = pVhsyudisptkhghkumu1;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu2() {
        return vhsyuddisptkhghkumu2;
    }

    @Override
    public void setVhsyudisptkhghkumu2(C_UmuKbn pVhsyudisptkhghkumu2) {
        vhsyuddisptkhghkumu2 = pVhsyudisptkhghkumu2;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu3() {
        return vhsyuddisptkhghkumu3;
    }

    @Override
    public void setVhsyudisptkhghkumu3(C_UmuKbn pVhsyudisptkhghkumu3) {
        vhsyuddisptkhghkumu3 = pVhsyudisptkhghkumu3;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu4() {
        return vhsyuddisptkhghkumu4;
    }

    @Override
    public void setVhsyudisptkhghkumu4(C_UmuKbn pVhsyudisptkhghkumu4) {
        vhsyuddisptkhghkumu4 = pVhsyudisptkhghkumu4;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu5() {
        return vhsyuddisptkhghkumu5;
    }

    @Override
    public void setVhsyudisptkhghkumu5(C_UmuKbn pVhsyudisptkhghkumu5) {
        vhsyuddisptkhghkumu5 = pVhsyudisptkhghkumu5;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu6() {
        return vhsyuddisptkhghkumu6;
    }

    @Override
    public void setVhsyudisptkhghkumu6(C_UmuKbn pVhsyudisptkhghkumu6) {
        vhsyuddisptkhghkumu6 = pVhsyudisptkhghkumu6;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu7() {
        return vhsyuddisptkhghkumu7;
    }

    @Override
    public void setVhsyudisptkhghkumu7(C_UmuKbn pVhsyudisptkhghkumu7) {
        vhsyuddisptkhghkumu7 = pVhsyudisptkhghkumu7;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu8() {
        return vhsyuddisptkhghkumu8;
    }

    @Override
    public void setVhsyudisptkhghkumu8(C_UmuKbn pVhsyudisptkhghkumu8) {
        vhsyuddisptkhghkumu8 = pVhsyudisptkhghkumu8;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu9() {
        return vhsyuddisptkhghkumu9;
    }

    @Override
    public void setVhsyudisptkhghkumu9(C_UmuKbn pVhsyudisptkhghkumu9) {
        vhsyuddisptkhghkumu9 = pVhsyudisptkhghkumu9;
    }

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu10() {
        return vhsyuddisptkhghkumu10;
    }

    @Override
    public void setVhsyudisptkhghkumu10(C_UmuKbn pVhsyudisptkhghkumu10) {
        vhsyuddisptkhghkumu10 = pVhsyudisptkhghkumu10;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu1() {
        return vhsyudisptkgannyukyhumu1;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu1(C_UmuKbn pVhsyudisptkgannyukyhumu1) {
        vhsyudisptkgannyukyhumu1 = pVhsyudisptkgannyukyhumu1;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu2() {
        return vhsyudisptkgannyukyhumu2;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu2(C_UmuKbn pVhsyudisptkgannyukyhumu2) {
        vhsyudisptkgannyukyhumu2 = pVhsyudisptkgannyukyhumu2;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu3() {
        return vhsyudisptkgannyukyhumu3;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu3(C_UmuKbn pVhsyudisptkgannyukyhumu3) {
        vhsyudisptkgannyukyhumu3 = pVhsyudisptkgannyukyhumu3;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu4() {
        return vhsyudisptkgannyukyhumu4;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu4(C_UmuKbn pVhsyudisptkgannyukyhumu4) {
        vhsyudisptkgannyukyhumu4 = pVhsyudisptkgannyukyhumu4;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu5() {
        return vhsyudisptkgannyukyhumu5;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu5(C_UmuKbn pVhsyudisptkgannyukyhumu5) {
        vhsyudisptkgannyukyhumu5 = pVhsyudisptkgannyukyhumu5;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu6() {
        return vhsyudisptkgannyukyhumu6;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu6(C_UmuKbn pVhsyudisptkgannyukyhumu6) {
        vhsyudisptkgannyukyhumu6 = pVhsyudisptkgannyukyhumu6;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu7() {
        return vhsyudisptkgannyukyhumu7;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu7(C_UmuKbn pVhsyudisptkgannyukyhumu7) {
        vhsyudisptkgannyukyhumu7 = pVhsyudisptkgannyukyhumu7;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu8() {
        return vhsyudisptkgannyukyhumu8;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu8(C_UmuKbn pVhsyudisptkgannyukyhumu8) {
        vhsyudisptkgannyukyhumu8 = pVhsyudisptkgannyukyhumu8;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu9() {
        return vhsyudisptkgannyukyhumu9;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu9(C_UmuKbn pVhsyudisptkgannyukyhumu9) {
        vhsyudisptkgannyukyhumu9 = pVhsyudisptkgannyukyhumu9;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu10() {
        return vhsyudisptkgannyukyhumu10;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu10(C_UmuKbn pVhsyudisptkgannyukyhumu10) {
        vhsyudisptkgannyukyhumu10 = pVhsyudisptkgannyukyhumu10;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu1() {
        return vhsyudisptksndkyhkinshrskgnumu1;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu1(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu1) {
        vhsyudisptksndkyhkinshrskgnumu1 = pVhsyudisptksndkyhkinshrskgnumu1;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu2() {
        return vhsyudisptksndkyhkinshrskgnumu2;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu2(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu2) {
        vhsyudisptksndkyhkinshrskgnumu2 = pVhsyudisptksndkyhkinshrskgnumu2;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu3() {
        return vhsyudisptksndkyhkinshrskgnumu3;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu3(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu3) {
        vhsyudisptksndkyhkinshrskgnumu3 = pVhsyudisptksndkyhkinshrskgnumu3;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu4() {
        return vhsyudisptksndkyhkinshrskgnumu4;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu4(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu4) {
        vhsyudisptksndkyhkinshrskgnumu4 = pVhsyudisptksndkyhkinshrskgnumu4;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu5() {
        return vhsyudisptksndkyhkinshrskgnumu5;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu5(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu5) {
        vhsyudisptksndkyhkinshrskgnumu5 = pVhsyudisptksndkyhkinshrskgnumu5;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu6() {
        return vhsyudisptksndkyhkinshrskgnumu6;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu6(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu6) {
        vhsyudisptksndkyhkinshrskgnumu6 = pVhsyudisptksndkyhkinshrskgnumu6;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu7() {
        return vhsyudisptksndkyhkinshrskgnumu7;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu7(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu7) {
        vhsyudisptksndkyhkinshrskgnumu7 = pVhsyudisptksndkyhkinshrskgnumu7;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu8() {
        return vhsyudisptksndkyhkinshrskgnumu8;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu8(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu8) {
        vhsyudisptksndkyhkinshrskgnumu8 = pVhsyudisptksndkyhkinshrskgnumu8;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu9() {
        return vhsyudisptksndkyhkinshrskgnumu9;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu9(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu9) {
        vhsyudisptksndkyhkinshrskgnumu9 = pVhsyudisptksndkyhkinshrskgnumu9;
    }

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu10() {
        return vhsyudisptksndkyhkinshrskgnumu10;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu10(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu10) {
        vhsyudisptksndkyhkinshrskgnumu10 = pVhsyudisptksndkyhkinshrskgnumu10;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu1() {
        return vhsyudisptknextkosumu1;
    }

    @Override
    public void setVhsyudisptknextkosumu1(C_UmuKbn pVhsyudisptknextkosumu1) {
        vhsyudisptknextkosumu1 = pVhsyudisptknextkosumu1;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu2() {
        return vhsyudisptknextkosumu2;
    }

    @Override
    public void setVhsyudisptknextkosumu2(C_UmuKbn pVhsyudisptknextkosumu2) {
        vhsyudisptknextkosumu2 = pVhsyudisptknextkosumu2;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu3() {
        return vhsyudisptknextkosumu3;
    }

    @Override
    public void setVhsyudisptknextkosumu3(C_UmuKbn pVhsyudisptknextkosumu3) {
        vhsyudisptknextkosumu3 = pVhsyudisptknextkosumu3;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu4() {
        return vhsyudisptknextkosumu4;
    }

    @Override
    public void setVhsyudisptknextkosumu4(C_UmuKbn pVhsyudisptknextkosumu4) {
        vhsyudisptknextkosumu4 = pVhsyudisptknextkosumu4;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu5() {
        return vhsyudisptknextkosumu5;
    }

    @Override
    public void setVhsyudisptknextkosumu5(C_UmuKbn pVhsyudisptknextkosumu5) {
        vhsyudisptknextkosumu5 = pVhsyudisptknextkosumu5;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu6() {
        return vhsyudisptknextkosumu6;
    }

    @Override
    public void setVhsyudisptknextkosumu6(C_UmuKbn pVhsyudisptknextkosumu6) {
        vhsyudisptknextkosumu6 = pVhsyudisptknextkosumu6;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu7() {
        return vhsyudisptknextkosumu7;
    }

    @Override
    public void setVhsyudisptknextkosumu7(C_UmuKbn pVhsyudisptknextkosumu7) {
        vhsyudisptknextkosumu7 = pVhsyudisptknextkosumu7;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu8() {
        return vhsyudisptknextkosumu8;
    }

    @Override
    public void setVhsyudisptknextkosumu8(C_UmuKbn pVhsyudisptknextkosumu8) {
        vhsyudisptknextkosumu8 = pVhsyudisptknextkosumu8;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu9() {
        return vhsyudisptknextkosumu9;
    }

    @Override
    public void setVhsyudisptknextkosumu9(C_UmuKbn pVhsyudisptknextkosumu9) {
        vhsyudisptknextkosumu9 = pVhsyudisptknextkosumu9;
    }

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu10() {
        return vhsyudisptknextkosumu10;
    }

    @Override
    public void setVhsyudisptknextkosumu10(C_UmuKbn pVhsyudisptknextkosumu10) {
        vhsyudisptknextkosumu10 = pVhsyudisptknextkosumu10;
    }

    @Override
    public C_UmuKbn getVhsyusyutsnshrgndhjumu() {
        return vhsyusyutsnshrgndhjumu;
    }

    @Override
    public void setVhsyusyutsnshrgndhjumu(C_UmuKbn pVhsyusyutsnshrgndhjumu) {
        vhsyusyutsnshrgndhjumu = pVhsyusyutsnshrgndhjumu;
    }

    @Override
    public BizCurrency getVhsyudispsyutsnshrgndgk() {
        return vhsyudispsyutsnshrgndgk;
    }

    @Override
    public void setVhsyudispsyutsnshrgndgk(BizCurrency pVhsyudispsyutsnshrgndgk) {
        vhsyudispsyutsnshrgndgk = pVhsyudispsyutsnshrgndgk;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu1() {
        return vhsyudisptktsnshrgndhjumu1;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu1(C_UmuKbn pVhsyudisptktsnshrgndhjumu1) {
        vhsyudisptktsnshrgndhjumu1 = pVhsyudisptktsnshrgndhjumu1;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu2() {
        return vhsyudisptktsnshrgndhjumu2;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu2(C_UmuKbn pVhsyudisptktsnshrgndhjumu2) {
        vhsyudisptktsnshrgndhjumu2 = pVhsyudisptktsnshrgndhjumu2;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu3() {
        return vhsyudisptktsnshrgndhjumu3;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu3(C_UmuKbn pVhsyudisptktsnshrgndhjumu3) {
        vhsyudisptktsnshrgndhjumu3 = pVhsyudisptktsnshrgndhjumu3;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu4() {
        return vhsyudisptktsnshrgndhjumu4;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu4(C_UmuKbn pVhsyudisptktsnshrgndhjumu4) {
        vhsyudisptktsnshrgndhjumu4 = pVhsyudisptktsnshrgndhjumu4;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu5() {
        return vhsyudisptktsnshrgndhjumu5;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu5(C_UmuKbn pVhsyudisptktsnshrgndhjumu5) {
        vhsyudisptktsnshrgndhjumu5 = pVhsyudisptktsnshrgndhjumu5;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu6() {
        return vhsyudisptktsnshrgndhjumu6;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu6(C_UmuKbn pVhsyudisptktsnshrgndhjumu6) {
        vhsyudisptktsnshrgndhjumu6 = pVhsyudisptktsnshrgndhjumu6;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu7() {
        return vhsyudisptktsnshrgndhjumu7;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu7(C_UmuKbn pVhsyudisptktsnshrgndhjumu7) {
        vhsyudisptktsnshrgndhjumu7 = pVhsyudisptktsnshrgndhjumu7;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu8() {
        return vhsyudisptktsnshrgndhjumu8;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu8(C_UmuKbn pVhsyudisptktsnshrgndhjumu8) {
        vhsyudisptktsnshrgndhjumu8 = pVhsyudisptktsnshrgndhjumu8;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu9() {
        return vhsyudisptktsnshrgndhjumu9;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu9(C_UmuKbn pVhsyudisptktsnshrgndhjumu9) {
        vhsyudisptktsnshrgndhjumu9 = pVhsyudisptktsnshrgndhjumu9;
    }

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu10() {
        return vhsyudisptktsnshrgndhjumu10;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu10(C_UmuKbn pVhsyudisptktsnshrgndhjumu10) {
        vhsyudisptktsnshrgndhjumu10 = pVhsyudisptktsnshrgndhjumu10;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk1() {
        return vhsyudisptktsnshrgndgk1;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk1(BizCurrency pVhsyudisptktsnshrgndgk1) {
        vhsyudisptktsnshrgndgk1 = pVhsyudisptktsnshrgndgk1;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk2() {
        return vhsyudisptktsnshrgndgk2;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk2(BizCurrency pVhsyudisptktsnshrgndgk2) {
        vhsyudisptktsnshrgndgk2 = pVhsyudisptktsnshrgndgk2;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk3() {
        return vhsyudisptktsnshrgndgk3;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk3(BizCurrency pVhsyudisptktsnshrgndgk3) {
        vhsyudisptktsnshrgndgk3 = pVhsyudisptktsnshrgndgk3;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk4() {
        return vhsyudisptktsnshrgndgk4;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk4(BizCurrency pVhsyudisptktsnshrgndgk4) {
        vhsyudisptktsnshrgndgk4 = pVhsyudisptktsnshrgndgk4;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk5() {
        return vhsyudisptktsnshrgndgk5;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk5(BizCurrency pVhsyudisptktsnshrgndgk5) {
        vhsyudisptktsnshrgndgk5 = pVhsyudisptktsnshrgndgk5;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk6() {
        return vhsyudisptktsnshrgndgk6;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk6(BizCurrency pVhsyudisptktsnshrgndgk6) {
        vhsyudisptktsnshrgndgk6 = pVhsyudisptktsnshrgndgk6;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk7() {
        return vhsyudisptktsnshrgndgk7;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk7(BizCurrency pVhsyudisptktsnshrgndgk7) {
        vhsyudisptktsnshrgndgk7 = pVhsyudisptktsnshrgndgk7;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk8() {
        return vhsyudisptktsnshrgndgk8;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk8(BizCurrency pVhsyudisptktsnshrgndgk8) {
        vhsyudisptktsnshrgndgk8 = pVhsyudisptktsnshrgndgk8;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk9() {
        return vhsyudisptktsnshrgndgk9;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk9(BizCurrency pVhsyudisptktsnshrgndgk9) {
        vhsyudisptktsnshrgndgk9 = pVhsyudisptktsnshrgndgk9;
    }

    @Override
    public BizCurrency getVhsyudisptktsnshrgndgk10() {
        return vhsyudisptktsnshrgndgk10;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk10(BizCurrency pVhsyudisptktsnshrgndgk10) {
        vhsyudisptktsnshrgndgk10 = pVhsyudisptktsnshrgndgk10;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn1() {
        return vhsyudisptkkgbairitukbn1;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn1(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn1) {
        vhsyudisptkkgbairitukbn1 = pVhsyudisptkkgbairitukbn1;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn2() {
        return vhsyudisptkkgbairitukbn2;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn2(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn2) {
        vhsyudisptkkgbairitukbn2 = pVhsyudisptkkgbairitukbn2;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn3() {
        return vhsyudisptkkgbairitukbn3;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn3(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn3) {
        vhsyudisptkkgbairitukbn3 = pVhsyudisptkkgbairitukbn3;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn4() {
        return vhsyudisptkkgbairitukbn4;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn4(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn4) {
        vhsyudisptkkgbairitukbn4 = pVhsyudisptkkgbairitukbn4;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn5() {
        return vhsyudisptkkgbairitukbn5;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn5(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn5) {
        vhsyudisptkkgbairitukbn5 = pVhsyudisptkkgbairitukbn5;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn6() {
        return vhsyudisptkkgbairitukbn6;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn6(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn6) {
        vhsyudisptkkgbairitukbn6 = pVhsyudisptkkgbairitukbn6;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn7() {
        return vhsyudisptkkgbairitukbn7;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn7(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn7) {
        vhsyudisptkkgbairitukbn7 = pVhsyudisptkkgbairitukbn7;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn8() {
        return vhsyudisptkkgbairitukbn8;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn8(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn8) {
        vhsyudisptkkgbairitukbn8 = pVhsyudisptkkgbairitukbn8;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn9() {
        return vhsyudisptkkgbairitukbn9;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn9(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn9) {
        vhsyudisptkkgbairitukbn9 = pVhsyudisptkkgbairitukbn9;
    }

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn10() {
        return vhsyudisptkkgbairitukbn10;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn10(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn10) {
        vhsyudisptkkgbairitukbn10 = pVhsyudisptkkgbairitukbn10;
    }

    @Override
    public C_UmuKbn getVhsyunstkhukaumukbn() {
        return vhsyunstkhukaumukbn;
    }

    @Override
    public void setVhsyunstkhukaumukbn(C_UmuKbn pVhsyunstkhukaumukbn) {
        vhsyunstkhukaumukbn = pVhsyunstkhukaumukbn;
    }

    @Override
    public C_UmuKbn getVhsyudai1hknkknsbsyokuseiumu() {
        return vhsyudai1hknkknsbsyokuseiumu;
    }

    @Override
    public void setVhsyudai1hknkknsbsyokuseiumu(C_UmuKbn pVhsyudai1hknkknsbsyokuseiumu) {
        vhsyudai1hknkknsbsyokuseiumu = pVhsyudai1hknkknsbsyokuseiumu;
    }

    @Override
    public C_UmuKbn getVhsyusgsbhsyumu() {
        return vhsyusgsbhsyumu;
    }

    @Override
    public void setVhsyusgsbhsyumu(C_UmuKbn pVhsyusgsbhsyumu) {
        vhsyusgsbhsyumu = pVhsyusgsbhsyumu;
    }

    @Override
    public C_HknKknKbn getVhsyuhknKknKbn() {
        return vhsyuhknKknKbn;
    }

    @Override
    public void setVhsyuhknKknKbn(C_HknKknKbn pVhsyuhknKknKbn) {
        vhsyuhknKknKbn = pVhsyuhknKknKbn;
    }

    @Override
    public void setVhsyusyohinhanteikbn(int pVhsyusyohinhanteikbn) {
        vhsyusyohinhanteikbn = pVhsyusyohinhanteikbn;
    }

    @Override
    public void setVhsyumvatekiumu(C_UmuKbn pVhsyumvatekiumu) {
        vhsyumvatekiumu = pVhsyumvatekiumu;
    }

    @Override
    public void setVhsyusbhkuktumu(C_UmuKbn pVhsyusbhkuktumu) {
        vhsyusbhkuktumu = pVhsyusbhkuktumu;
    }

    @Override
    public void setVhsyusbkyuuhukinuktumu(C_UmuKbn pVhsyusbkyuuhukinuktumu) {
        vhsyusbkyuuhukinuktumu = pVhsyusbkyuuhukinuktumu;
    }

    @Override
    public void setVhsyuyendthnkymd(BizDate pVhsyuyendthnkymd) {
        vhsyuyendthnkymd = pVhsyuyendthnkymd;
    }

    @Override
    public void setVhsyusyunkshrstartymd(BizDate pVhsyusyunkshrstartymd) {
        vhsyusyunkshrstartymd = pVhsyusyunkshrstartymd;
    }

    @Override
    public void setVhsyuteiritutmttkngk(BizCurrency pVhsyuteiritutmttkngk) {
        vhsyuteiritutmttkngk = pVhsyuteiritutmttkngk;
    }

    @Override
    public void setVhsyusisuurendoutmttkngk(BizCurrency pVhsyusisuurendoutmttkngk) {
        vhsyusisuurendoutmttkngk = pVhsyusisuurendoutmttkngk;
    }

    @Override
    public void setVhsyugenzaitmttkngk(BizCurrency pVhsyugenzaitmttkngk) {
        vhsyugenzaitmttkngk = pVhsyugenzaitmttkngk;
    }

    @Override
    public void setVhsyusisuurendourate(BizNumber pVhsyusisuurendourate) {
        vhsyusisuurendourate = pVhsyusisuurendourate;
    }

    @Override
    public void setVhsyuteiritutmttrate(BizNumber pVhsyuteiritutmttrate) {
        vhsyuteiritutmttrate = pVhsyuteiritutmttrate;
    }

    @Override
    public void setVhsyusisuunm(String pVhsyusisuunm) {
        vhsyusisuunm = pVhsyusisuunm;
    }

    @Override
    public void setVhsyusetteibairitu(BizNumber pVhsyusetteibairitu) {
        vhsyusetteibairitu = pVhsyusetteibairitu;
    }

    @Override
    public void setVhsyuyoteiriritu(BizNumber pVhsyuyoteiriritu) {
        vhsyuyoteiriritu = pVhsyuyoteiriritu;
    }

    @Override
    public void setVhsyutumitateriritu(BizNumber pVhsyutumitateriritu) {
        vhsyutumitateriritu = pVhsyutumitateriritu;
    }

    @Override
    public void setVhsyukyksjkkktyouseiriritu(BizNumber pVhsyukyksjkkktyouseiriritu) {
        vhsyukyksjkkktyouseiriritu = pVhsyukyksjkkktyouseiriritu;
    }

    @Override
    public void setVhsyuskisjkkktyouseiriritu(BizNumber pVhsyuskisjkkktyouseiriritu) {
        vhsyuskisjkkktyouseiriritu = pVhsyuskisjkkktyouseiriritu;
    }

    @Override
    public void setVhsyuyendthnkjyoutaikbn(C_YendthnkJyoutaiKbn pVhsyuyendthnkjyoutaikbn) {
        vhsyuyendthnkjyoutaikbn = pVhsyuyendthnkjyoutaikbn;
    }

    @Override
    public int getVhsyusyohinhanteikbn() {
        return vhsyusyohinhanteikbn;
    }

    @Override
    public C_UmuKbn getVhsyumvatekiumu() {
        return vhsyumvatekiumu;
    }

    @Override
    public C_UmuKbn getVhsyusbhkuktumu() {
        return vhsyusbhkuktumu;
    }

    @Override
    public C_UmuKbn getVhsyusbkyuuhukinuktumu() {
        return vhsyusbkyuuhukinuktumu;
    }

    @Override
    public BizDate getVhsyuyendthnkymd() {
        return vhsyuyendthnkymd;
    }

    @Override
    public BizDate getVhsyusyunkshrstartymd() {
        return vhsyusyunkshrstartymd;
    }

    @Override
    public BizCurrency getVhsyuteiritutmttkngk() {
        return vhsyuteiritutmttkngk;
    }

    @Override
    public BizCurrency getVhsyusisuurendoutmttkngk() {
        return vhsyusisuurendoutmttkngk;
    }

    @Override
    public BizCurrency getVhsyugenzaitmttkngk() {
        return vhsyugenzaitmttkngk;
    }

    @Override
    public BizNumber getVhsyusisuurendourate() {
        return vhsyusisuurendourate;
    }

    @Override
    public BizNumber getVhsyuteiritutmttrate() {
        return vhsyuteiritutmttrate;
    }

    @Override
    public String getVhsyusisuunm() {
        return vhsyusisuunm;
    }

    @Override
    public BizNumber getVhsyusetteibairitu() {
        return vhsyusetteibairitu;
    }

    @Override
    public BizNumber getVhsyuyoteiriritu() {
        return vhsyuyoteiriritu;
    }

    @Override
    public BizNumber getVhsyutumitateriritu() {
        return vhsyutumitateriritu;
    }

    @Override
    public BizNumber getVhsyukyksjkkktyouseiriritu() {
        return vhsyukyksjkkktyouseiriritu;
    }

    @Override
    public BizNumber getVhsyuskisjkkktyouseiriritu() {
        return vhsyuskisjkkktyouseiriritu;
    }

    @Override
    public C_YendthnkJyoutaiKbn getVhsyuyendthnkjyoutaikbn() {
        return vhsyuyendthnkjyoutaikbn;
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {

        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfoList = Lists.newArrayList();
        for (KikeiyakuInfoDataSourceBeanCommonParam beanPram : pKikeiyakuInfo) {
            kikeiyakuInfoList.add((KikeiyakuInfoDataSourceBean) beanPram);
        }

        super.setKikeiyakuInfo(kikeiyakuInfoList);
    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {

        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(

        List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaifoList = Lists.newArrayList();

        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pNenkinsiharaiInfo) {
            nenkinsiharaifoList.add((NenkinsiharaiInfoDataSourceBean) beanPram);
        }

        super.setNenkinsiharaiInfo(nenkinsiharaifoList);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {

        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {

        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfoList = Lists.newArrayList();
        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanPram : pPalkikeiyakuInfo) {
            palkikeiyakuInfoList.add((PalkikeiyakuInfoDataSourceBean) beanPram);
        }

        super.setPalkikeiyakuInfo(palkikeiyakuInfoList);
    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {

        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(

        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfoList = Lists.newArrayList();

        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pPalNenkinsiharaiInfo) {
            palnenkinsiharaiInfoList.add((PalnenkinsiharaiInfoDataSourceBean) beanPram);
        }

        super.setPalnenkinsiharaiInfo(palnenkinsiharaiInfoList);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {

        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {

        List<PalsueokiInfoDataSourceBean> palsueokiInfoList = Lists.newArrayList();
        for (PalsueokiInfoDataSourceBeanCommonParam beanPram : pPalsueokiInfo) {
            palsueokiInfoList.add((PalsueokiInfoDataSourceBean) beanPram);
        }

        super.setPalsueokiInfo(palsueokiInfoList);
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {

        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanPram : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean) beanPram);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

    @Override
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {

        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTbktInfoForCommonParam(List<TbktInfoDataSourceBeanCommonParam> pTbktInfo) {

        List<TbktInfoDataSourceBean> tbktInfo = Lists.newArrayList();

        for (TbktInfoDataSourceBeanCommonParam beanPram : pTbktInfo) {
            tbktInfo.add((TbktInfoDataSourceBean) beanPram);
        }

        super.setTbktInfo(tbktInfo);
    }

    @Override
    public TbktInfoDataSourceBeanCommonParam createTbktInfoDataSourceBean() {

        return new TbktInfoDataSourceBean();
    }
}
