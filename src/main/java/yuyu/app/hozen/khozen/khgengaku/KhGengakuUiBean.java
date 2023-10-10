package yuyu.app.hozen.khozen.khgengaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewkouteiinfo.ViewKouteiInfoUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.hozen.haitou.KhHaitouKanriKeyinfoBean;
import yuyu.common.hozen.khcommon.CheckKouzaChkSoukinsakiKouzaUiBeanParam;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khcommon.MiKeikaPBean;
import yuyu.common.hozen.khcommon.ZennouKoujyogakuKeisanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewdattai.ViewDattaiUiBeanParam;
import yuyu.common.hozen.khview.viewhaitoukin.ViewHaitoukinUiBeanParam;
import yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoUiBeanParam;
import yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewhosyou.ViewHosyouUiBeanParam;
import yuyu.common.hozen.khview.viewkariukekin.ViewKariukekinUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkhtkshrsiharaikouza.ViewKhTkshrSiharaiKouzaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewkouzainfo.ViewKouzaInfoUiBeanParam;
import yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiUiBeanParam;
import yuyu.common.hozen.khview.viewsonotatk.ViewSonotaTkUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtokusin.ViewTokusinUiBeanParam;
import yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam;
import yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam;
import yuyu.common.hozen.setuibean.KariukekinInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetDattaiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHaitoukinExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHituyouSyoruiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHosyouExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKariukekinExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhTkshrSiharaiKouzaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKyksyadairiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSonotaTkExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTokusinExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTrkKazokuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TbktInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 減額 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhGengakuUiBean extends GenKhGengakuUiBean implements
ViewKouteiInfoUiBeanParam, SetKouteiInfoExecUiBeanParam,
ViewBetukykUiBeanParam, SetBetukykExecUiBeanParam,
ViewKihonUiBeanParam, SetKihonExecUiBeanParam,
ViewTetudukityuuiUiBeanParam, SetTetudukityuuiExecUiBeanParam,
ViewKeiyakusyaUiBeanParam, SetKeiyakusyaExecUiBeanParam,
ViewTuusinsakiUiBeanParam, SetTuusinsakiExecUiBeanParam,
ViewHihokensyaUiBeanParam, SetHihokensyaExecUiBeanParam,
ViewHosyouUiBeanParam, SetHosyouExecUiBeanParam,
ViewSonotaTkUiBeanParam, SetSonotaTkExecUiBeanParam,
ViewHaraikomiInfoUiBeanParam, SetHaraikomiInfoExecUiBeanParam,
ViewSyoruiInfoItiranUiBeanParam, SetSyoruiInfoItiranExecUiBeanParam,
ViewProgressHistoryUiBeanParam, SetProgressHistoryExecUiBeanParam,
ViewKouzaInfoUiBeanParam,
ViewHituyouSyoruiUiBeanParam, SetHituyouSyoruiExecUiBeanParam,
CheckYuukouJyoutaiExecUiBeanParam,
SetToriatukaiTyuuiExecUiBeanParam,
CheckKouzaChkSoukinsakiKouzaUiBeanParam,
KhozenCommonParamGetHituyouSyoruiUiBeanParam,
SetKhKbnPatternUtilUiBeanParam,
SetKariukekinExecUiBeanParam,ViewKariukekinUiBeanParam,
SetDattaiExecUiBeanParam,ViewDattaiUiBeanParam,
SetHaitoukinExecUiBeanParam,ViewHaitoukinUiBeanParam,
SetTokusinExecUiBeanParam,ViewTokusinUiBeanParam,
SetTrkKazokuExecUiBeanParam,ViewTrkKazokuUiBeanParam,
SetKyksyadairiExecUiBeanParam,ViewKyksyadairiUiBeanParam,
SetKhTkshrSiharaiKouzaExecUiBeanParam,ViewKhTkshrSiharaiKouzaUiBeanParam
{

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private IT_KykKihon kykKihon;

    @Inject
    private KinouMode kinouMode;

    private String syono;

    private C_UmuKbn newSyunextkosUmu;

    private BizDateYM mikeikaPjyutouYm;

    private BizCurrency syuKaiyakuHr;

    private C_Tuukasyu syuTuukaSyu;

    private C_UmuKbn tyouhyoumuKbn;

    private String reportKey;

    private C_UmuKbn newNextkosUmu;

    private C_Sdpd sdpdKbn;

    private Integer syuGengakuKahiKbn;

    private BizCurrency dispNewtkKihonS;

    private BizDate kouryokuHasseiYmd;

    private String patternTkhnkkbn1;

    private String patternTkhnkkbn2;

    private String patternTkhnkkbn3;

    private String patternTkhnkkbn4;

    private String patternTkhnkkbn5;

    private String patternTkhnkkbn6;

    private String patternTkhnkkbn7;

    private String patternTkhnkkbn8;

    private String patternTkhnkkbn9;

    private String patternTkhnkkbn10;

    private Integer tkGengakukahikbn1;

    private Integer tkGengakukahikbn2;

    private Integer tkGengakukahikbn3;

    private Integer tkGengakukahikbn4;

    private Integer tkGengakukahikbn5;

    private Integer tkGengakukahikbn6;

    private Integer tkGengakukahikbn7;

    private Integer tkGengakukahikbn8;

    private Integer tkGengakukahikbn9;

    private Integer tkGengakukahikbn10;

    private C_SyorikahiKbn syoriKahiKbn;

    private BizCurrency  dispdtlmikeikap;

    private BizDate dispdtlmikeikapnykdenymd;

    private C_Hrkkaisuu dispdtlmikeikaphrkkaisuu;

    private BizDateYM dispdtlmikeikapjytym;

    private Integer dispdtlmikeikapjtkaisuuy;

    private Integer dispdtlmikeikapjtkaisuum;

    private BizCurrency dispTkKaiyakuHr1;

    private BizCurrency dispTkKaiyakuHr2;

    private BizCurrency dispTkKaiyakuHr3;

    private BizCurrency dispTkKaiyakuHr4;

    private BizCurrency dispTkKaiyakuHr5;

    private BizCurrency dispTkKaiyakuHr6;

    private BizCurrency dispTkKaiyakuHr7;

    private BizCurrency dispTkKaiyakuHr8;

    private BizCurrency dispTkKaiyakuHr9;

    private BizCurrency dispTkKaiyakuHr10;

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

    private C_UmuKbn vhsyuddisptkgannyukyhumu1;

    private C_UmuKbn vhsyuddisptkgannyukyhumu2;

    private C_UmuKbn vhsyuddisptkgannyukyhumu3;

    private C_UmuKbn vhsyuddisptkgannyukyhumu4;

    private C_UmuKbn vhsyuddisptkgannyukyhumu5;

    private C_UmuKbn vhsyuddisptkgannyukyhumu6;

    private C_UmuKbn vhsyuddisptkgannyukyhumu7;

    private C_UmuKbn vhsyuddisptkgannyukyhumu8;

    private C_UmuKbn vhsyuddisptkgannyukyhumu9;

    private C_UmuKbn vhsyuddisptkgannyukyhumu10;

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

    private C_HknKknKbn vhsyuhknKknKbn;

    private C_UmuKbn vhsyusgsbhsyumu;

    private int vhsyusyohinhanteikbn;

    private C_UmuKbn vhsyumvatekiumu;

    private C_UmuKbn vhsyusbhkuktumu;

    private C_UmuKbn vhsyusbkyuuhukinuktumu;

    private C_Tuukasyu shrtuukasyu;

    private String kyknmkn;

    private String syusyouhncd;

    private Integer syusyouhnsdno;

    private Integer syukyksyouhnrenno;

    private String syuryouritusdno;

    private BizNumber syuyoteiriritu;

    private C_UmuKbn dispnewtknextkosumu1;

    private C_UmuKbn dispnewtknextkosumu2;

    private C_UmuKbn dispnewtknextkosumu3;

    private C_UmuKbn dispnewtknextkosumu4;

    private C_UmuKbn dispnewtknextkosumu5;

    private C_UmuKbn dispnewtknextkosumu6;

    private C_UmuKbn dispnewtknextkosumu7;

    private C_UmuKbn dispnewtknextkosumu8;

    private C_UmuKbn dispnewtknextkosumu9;

    private C_UmuKbn dispnewtknextkosumu10;

    private Integer tksyouhnsdno1;

    private Integer tksyouhnsdno2;

    private Integer tksyouhnsdno3;

    private Integer tksyouhnsdno4;

    private Integer tksyouhnsdno5;

    private Integer tksyouhnsdno6;

    private Integer tksyouhnsdno7;

    private Integer tksyouhnsdno8;

    private Integer tksyouhnsdno9;

    private Integer tksyouhnsdno10;

    private Integer tkkyksyouhnrenno1;

    private Integer tkkyksyouhnrenno2;

    private Integer tkkyksyouhnrenno3;

    private Integer tkkyksyouhnrenno4;

    private Integer tkkyksyouhnrenno5;

    private Integer tkkyksyouhnrenno6;

    private Integer tkkyksyouhnrenno7;

    private Integer tkkyksyouhnrenno8;

    private Integer tkkyksyouhnrenno9;

    private Integer tkkyksyouhnrenno10;

    private String[] imageids;

    private int kawaseRateMinasiKbn;

    private int unitGkminasiKbn;

    private C_SyorikekkaKbn zenkaiSyoriKekka;

    private C_ShrhousiteiKbn shrhouSiteiKbn;

    private BizCurrency shrTsTmttkin;

    private BizCurrency sjkkktyouseigk;

    private BizNumber kaiyakuSjkkkTyouseiriRitu;

    List<String> warningMessageIdList = new ArrayList<>();

    List<String> warningMessageList = new ArrayList<>();

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    private String patternSyorikekkakbn;

    private C_KykhnkKbn pmnJtkHnkKbn;

    private C_UmuKbn yenShrTktekiUmu;

    private String banknmkj;

    private String sitennmkj;

    private C_UmuKbn nextkosumu;

    private C_Tuukasyu vhrkiyentkykwsratetuukasyu;

    private C_KahiKbn syukkyPgengakuKahiKbn;

    private BizNumber syukkyKyksjKkkTyouseiriRitu;

    private BizCurrency htykeihiYen;

    private C_HtsiryosyuKbn shrTysySyuruiKbn;

    private int fbSoukinEdaNo;

    private String sosikiCd;

    private String denrenNo;

    private CommonSiwakeOutBean commonSiwakeOutBean;

    private BizDate tienrisoKukisanYmd;

    private Integer tienrskNissuu;

    private BizDate jpyTienrisoKukisanYmd;

    private Integer jpyTienrskNissuu;

    private BizNumber sjkkktyouseirt;

    private C_UmuKbn yennykntkhkumu;

    private C_Tuukasyu kyktuukasyu;

    private int kykHnkKaisuu;

    private BizDate yendtHnkYmd;

    private C_UmuKbn gsBunriTaisyou;

    private int syouhinHanteiKbn;

    private BizNumber gengakuWariai;

    private BizCurrency teirituTmttkngk;

    private BizCurrency sisuuRendouTmttkngk;

    private BizCurrency kaiyakuKjgk;

    private BizNumber kaiyakuKoujyoritu;

    private C_UmuKbn gaikaGsBunriTaisyouFlag;

    private C_UmuKbn yenkaGsBunriTaisyouFlag;

    private BizCurrency gsTsZeigk;

    private BizCurrency gaikaShrYenGsTsZeigk;

    private BizCurrency gaikaShrYenGsTsZeigkNationaltax;

    private BizCurrency yenkaShrYenGsTsZeigkNationaltax;

    private BizCurrency gaikaShrYenGsTsZeigkLocaltax;

    private BizCurrency yenkaShrYenGsTsZeigkLocaltax;

    private BizCurrency gaikaShrYenGsTsTaisyouSaeki;

    private BizCurrency yenkaShrYenGsTsTaisyouSaeki;

    private BizCurrency yendthnkgstszeigk;

    private BizCurrency yendthnkGstsTaisyouSaeki;

    private BizCurrency keisanKhYenW;

    private BizCurrency gaikaShrYenHtyKeihi;

    private BizCurrency yenkaShrYenHtyKeihi;

    private C_RatesyutokukekkaKbn zeimuRatesyutokukekkaKbn;

    private C_UmuKbn gsBunriTaisyouFlag;

    private BizDate yendtTienRskKsnbi;

    private Integer yendtTienRskNissuu;

    private BizCurrency jpyGsTszeigk;

    private BizDate sksSakuseiYmd;

    private C_UmuKbn zeiseitkkktkykhukaumu;

    private C_Tuukasyu hrktuukasyu;

    private BizCurrency ptmttkngk;

    private BizCurrency kihrkmpstgk;

    private BizDateYM tmttkntaisyouym;

    private BizCurrency newZennoujihrkp;

    private BizCurrency newZennounyuukinkgk;

    private BizCurrency mikeikaP;

    private int mikeikaPJyutouKaisuuY;

    private int mikeikaPJyutouKaisuuM;

    private BizCurrency kariwariatedruigk;

    private BizCurrency kariwariatedgngkkngk;

    private BizCurrency kariwariatedshrgk;

    private KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean;

    private EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean;

    private BizCurrency yensonotashrgk;

    private BizCurrency hituyoukeihiitijisytktysgk;

    private BizCurrency zennouseisankgk;

    private ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam;

    private ZennouKoujyogakuKeisanParam henmaeZennouKoujyogakuKeisanParam;

    private Integer renno;

    private BizCurrency ptumitatekinTyoseimae;

    private BizDate ryosyuymd;

    private MiKeikaPBean[] miKeikaPBeans;

    private BizCurrency kihrkpssrrkyenkansanhenkankin;

    private C_UmuKbn mihaneiDUmu;

    private C_UmuKbn zennouMijyuutouFlg;

    private C_UmuKbn zennouJyutouTorikesiFlg;

    private BizDateYM lastPJyuutouYm;

    private BizCurrency saeki;

    private C_UmuKbn mynoSinkokuTaisyouFlg;

    private String patternSoukinsakikbn;

    private C_UmuKbn heijyunbaraiumu;

    private C_UmuKbn itijibrumu;

    private C_HijynbrKanritukaHantKbn hijynbrKanritukaHantKbn;

    private C_Tuukasyu rstuukasyu;

    private BizCurrency mikeikapGengakuMae;

    private BizCurrency mikeikapGengakuGo;

    private BizCurrency zennouseisankinGengakuMae;

    private BizCurrency zennouseisankinGengakuGo;

    private BizCurrency zennounyuukinkgkrstk;

    private BizNumber zennounyuukinkgkryosyukwsrate;

    private BizDate zennounyuukinkgkryosyukwsratekjymd;

    private BizCurrency yenkansannyknkingk;

    private BizNumber yenkansannyknkingkryosyukwsrate;

    private BizDate yenkansannyknkingkryosyukwsratekjymd;

    private BizCurrency kaiyakuhrkngkkeisiteituuka;

    private BizCurrency jpykaiyakuhr;

    public KhGengakuUiBean() {
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public KinouMode getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(KinouMode pKinouMode) {
        kinouMode = pKinouMode;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_UmuKbn getNewSyunextkosUmu() {
        return newSyunextkosUmu;
    }

    public void setNewSyunextkosUmu(C_UmuKbn pNewSyunextkosUmu) {
        newSyunextkosUmu = pNewSyunextkosUmu;
    }

    public BizDateYM getMikeikaPjyutouYm() {
        return mikeikaPjyutouYm;
    }

    public void setMikeikaPjyutouYm(BizDateYM pMikeikaPjyutouYm) {
        mikeikaPjyutouYm = pMikeikaPjyutouYm;
    }

    public BizCurrency getSyuKaiyakuHr() {
        return syuKaiyakuHr;
    }

    public void setSyuKaiyakuHr(BizCurrency pSyuKaiyakuHr) {
        syuKaiyakuHr = pSyuKaiyakuHr;
    }

    public C_Tuukasyu getSyuTuukaSyu() {
        return syuTuukaSyu;
    }

    public void setSyuTuukaSyu(C_Tuukasyu pSyuTuukaSyu) {
        syuTuukaSyu = pSyuTuukaSyu;
    }

    public C_UmuKbn getTyouhyoumuKbn() {
        return tyouhyoumuKbn;
    }

    public void setTyouhyoumuKbn(C_UmuKbn pTyouhyoumuKbn) {
        tyouhyoumuKbn = pTyouhyoumuKbn;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

    public C_UmuKbn getNewNextkosUmu() {
        return newNextkosUmu;
    }

    public void setNewNextkosUmu(C_UmuKbn pNewNextkosUmu) {
        newNextkosUmu = pNewNextkosUmu;
    }

    public C_Sdpd getSdpdKbn() {
        return sdpdKbn;
    }

    public void setSdpdKbn(C_Sdpd pSdpdKbn) {
        sdpdKbn = pSdpdKbn;
    }

    public Integer getSyuGengakuKahiKbn() {
        return syuGengakuKahiKbn;
    }

    public void setSyuGengakuKahiKbn(Integer pSyuGengakuKahiKbn) {
        syuGengakuKahiKbn = pSyuGengakuKahiKbn;
    }

    public BizCurrency getDispNewtkKihonS() {
        return dispNewtkKihonS;
    }

    public void setDispNewtkKihonS(BizCurrency pDispNewtkKihonS) {
        dispNewtkKihonS = pDispNewtkKihonS;
    }

    public BizDate getKouryokuHasseiYmd() {
        return kouryokuHasseiYmd;
    }

    public void setKouryokuHasseiYmd(BizDate pKouryokuHasseiYmd) {
        kouryokuHasseiYmd = pKouryokuHasseiYmd;
    }

    public String getPatternTkhnkkbn1() {
        return patternTkhnkkbn1;
    }

    public void setPatternTkhnkkbn1(String pPatternTkhnkkbn1) {
        patternTkhnkkbn1 = pPatternTkhnkkbn1;
    }

    public String getPatternTkhnkkbn2() {
        return patternTkhnkkbn2;
    }

    public void setPatternTkhnkkbn2(String pPatternTkhnkkbn2) {
        patternTkhnkkbn2 = pPatternTkhnkkbn2;
    }

    public String getPatternTkhnkkbn3() {
        return patternTkhnkkbn3;
    }

    public void setPatternTkhnkkbn3(String pPatternTkhnkkbn3) {
        patternTkhnkkbn3 = pPatternTkhnkkbn3;
    }

    public String getPatternTkhnkkbn4() {
        return patternTkhnkkbn4;
    }

    public void setPatternTkhnkkbn4(String pPatternTkhnkkbn4) {
        patternTkhnkkbn4 = pPatternTkhnkkbn4;
    }

    public String getPatternTkhnkkbn5() {
        return patternTkhnkkbn5;
    }

    public void setPatternTkhnkkbn5(String pPatternTkhnkkbn5) {
        patternTkhnkkbn5 = pPatternTkhnkkbn5;
    }

    public String getPatternTkhnkkbn6() {
        return patternTkhnkkbn6;
    }

    public void setPatternTkhnkkbn6(String pPatternTkhnkkbn6) {
        patternTkhnkkbn6 = pPatternTkhnkkbn6;
    }

    public String getPatternTkhnkkbn7() {
        return patternTkhnkkbn7;
    }

    public void setPatternTkhnkkbn7(String pPatternTkhnkkbn7) {
        patternTkhnkkbn7 = pPatternTkhnkkbn7;
    }

    public String getPatternTkhnkkbn8() {
        return patternTkhnkkbn8;
    }

    public void setPatternTkhnkkbn8(String pPatternTkhnkkbn8) {
        patternTkhnkkbn8 = pPatternTkhnkkbn8;
    }

    public String getPatternTkhnkkbn9() {
        return patternTkhnkkbn9;
    }

    public void setPatternTkhnkkbn9(String pPatternTkhnkkbn9) {
        patternTkhnkkbn9 = pPatternTkhnkkbn9;
    }

    public String getPatternTkhnkkbn10() {
        return patternTkhnkkbn10;
    }

    public void setPatternTkhnkkbn10(String pPatternTkhnkkbn10) {
        patternTkhnkkbn10 = pPatternTkhnkkbn10;
    }

    public Integer getTkGengakukahikbn1() {
        return tkGengakukahikbn1;
    }

    public void setTkGengakukahikbn1(Integer pTkGengakukahikbn1) {
        tkGengakukahikbn1 = pTkGengakukahikbn1;
    }

    public Integer getTkGengakukahikbn2() {
        return tkGengakukahikbn2;
    }

    public void setTkGengakukahikbn2(Integer pTkGengakukahikbn2) {
        tkGengakukahikbn2 = pTkGengakukahikbn2;
    }

    public Integer getTkGengakukahikbn3() {
        return tkGengakukahikbn3;
    }

    public void setTkGengakukahikbn3(Integer pTkGengakukahikbn3) {
        tkGengakukahikbn3 = pTkGengakukahikbn3;
    }

    public Integer getTkGengakukahikbn4() {
        return tkGengakukahikbn4;
    }

    public void setTkGengakukahikbn4(Integer pTkGengakukahikbn4) {
        tkGengakukahikbn4 = pTkGengakukahikbn4;
    }

    public Integer getTkGengakukahikbn5() {
        return tkGengakukahikbn5;
    }

    public void setTkGengakukahikbn5(Integer pTkGengakukahikbn5) {
        tkGengakukahikbn5 = pTkGengakukahikbn5;
    }

    public Integer getTkGengakukahikbn6() {
        return tkGengakukahikbn6;
    }

    public void setTkGengakukahikbn6(Integer pTkGengakukahikbn6) {
        tkGengakukahikbn6 = pTkGengakukahikbn6;
    }

    public Integer getTkGengakukahikbn7() {
        return tkGengakukahikbn7;
    }

    public void setTkGengakukahikbn7(Integer pTkGengakukahikbn7) {
        tkGengakukahikbn7 = pTkGengakukahikbn7;
    }

    public Integer getTkGengakukahikbn8() {
        return tkGengakukahikbn8;
    }

    public void setTkGengakukahikbn8(Integer pTkGengakukahikbn8) {
        tkGengakukahikbn8 = pTkGengakukahikbn8;
    }

    public Integer getTkGengakukahikbn9() {
        return tkGengakukahikbn9;
    }

    public void setTkGengakukahikbn9(Integer pTkGengakukahikbn9) {
        tkGengakukahikbn9 = pTkGengakukahikbn9;
    }

    public Integer getTkGengakukahikbn10() {
        return tkGengakukahikbn10;
    }

    public void setTkGengakukahikbn10(Integer pTkGengakukahikbn10) {
        tkGengakukahikbn10 = pTkGengakukahikbn10;
    }

    public C_SyorikahiKbn getSyoriKahiKbn() {
        return syoriKahiKbn;
    }

    public void setSyoriKahiKbn(C_SyorikahiKbn pSyoriKahiKbn) {
        syoriKahiKbn = pSyoriKahiKbn;
    }

    public BizCurrency getDispdtlmikeikap() {
        return dispdtlmikeikap;
    }

    public void setDispdtlmikeikap(BizCurrency pDispdtlmikeikap) {
        dispdtlmikeikap = pDispdtlmikeikap;
    }

    public BizDate getDispdtlmikeikapnykdenymd() {
        return dispdtlmikeikapnykdenymd;
    }

    public void setDispdtlmikeikapnykdenymd(BizDate pDispdtlmikeikapnykdenymd) {
        dispdtlmikeikapnykdenymd = pDispdtlmikeikapnykdenymd;
    }

    public C_Hrkkaisuu getDispdtlmikeikaphrkkaisuu() {
        return dispdtlmikeikaphrkkaisuu;
    }

    public void setDispdtlmikeikaphrkkaisuu(C_Hrkkaisuu pDispdtlmikeikaphrkkaisuu) {
        dispdtlmikeikaphrkkaisuu = pDispdtlmikeikaphrkkaisuu;
    }

    public BizDateYM getDispdtlmikeikapjytym() {
        return dispdtlmikeikapjytym;
    }

    public void setDispdtlmikeikapjytym(BizDateYM pDispdtlmikeikapjytym) {
        dispdtlmikeikapjytym = pDispdtlmikeikapjytym;
    }

    public Integer getDispdtlmikeikapjtkaisuuy() {
        return dispdtlmikeikapjtkaisuuy;
    }

    public void setDispdtlmikeikapjtkaisuuy(Integer pDispdtlmikeikapjtkaisuuy) {
        dispdtlmikeikapjtkaisuuy = pDispdtlmikeikapjtkaisuuy;
    }

    public Integer getDispdtlmikeikapjtkaisuum() {
        return dispdtlmikeikapjtkaisuum;
    }

    public void setDispdtlmikeikapjtkaisuum(Integer pDispdtlmikeikapjtkaisuum) {
        dispdtlmikeikapjtkaisuum = pDispdtlmikeikapjtkaisuum;
    }

    public BizCurrency getDispTkKaiyakuHr1() {
        return dispTkKaiyakuHr1;
    }

    public void setDispTkKaiyakuHr1(BizCurrency pDispTkKaiyakuHr1) {
        dispTkKaiyakuHr1 = pDispTkKaiyakuHr1;
    }

    public BizCurrency getDispTkKaiyakuHr2() {
        return dispTkKaiyakuHr2;
    }

    public void setDispTkKaiyakuHr2(BizCurrency pDispTkKaiyakuHr2) {
        dispTkKaiyakuHr2 = pDispTkKaiyakuHr2;
    }

    public BizCurrency getDispTkKaiyakuHr3() {
        return dispTkKaiyakuHr3;
    }

    public void setDispTkKaiyakuHr3(BizCurrency pDispTkKaiyakuHr3) {
        dispTkKaiyakuHr3 = pDispTkKaiyakuHr3;
    }

    public BizCurrency getDispTkKaiyakuHr4() {
        return dispTkKaiyakuHr4;
    }

    public void setDispTkKaiyakuHr4(BizCurrency pDispTkKaiyakuHr4) {
        dispTkKaiyakuHr4 = pDispTkKaiyakuHr4;
    }

    public BizCurrency getDispTkKaiyakuHr5() {
        return dispTkKaiyakuHr5;
    }

    public void setDispTkKaiyakuHr5(BizCurrency pDispTkKaiyakuHr5) {
        dispTkKaiyakuHr5 = pDispTkKaiyakuHr5;
    }

    public BizCurrency getDispTkKaiyakuHr6() {
        return dispTkKaiyakuHr6;
    }

    public void setDispTkKaiyakuHr6(BizCurrency pDispTkKaiyakuHr6) {
        dispTkKaiyakuHr6 = pDispTkKaiyakuHr6;
    }

    public BizCurrency getDispTkKaiyakuHr7() {
        return dispTkKaiyakuHr7;
    }

    public void setDispTkKaiyakuHr7(BizCurrency pDispTkKaiyakuHr7) {
        dispTkKaiyakuHr7 = pDispTkKaiyakuHr7;
    }

    public BizCurrency getDispTkKaiyakuHr8() {
        return dispTkKaiyakuHr8;
    }

    public void setDispTkKaiyakuHr8(BizCurrency pDispTkKaiyakuHr8) {
        dispTkKaiyakuHr8 = pDispTkKaiyakuHr8;
    }

    public BizCurrency getDispTkKaiyakuHr9() {
        return dispTkKaiyakuHr9;
    }

    public void setDispTkKaiyakuHr9(BizCurrency pDispTkKaiyakuHr9) {
        dispTkKaiyakuHr9 = pDispTkKaiyakuHr9;
    }

    public BizCurrency getDispTkKaiyakuHr10() {
        return dispTkKaiyakuHr10;
    }

    public void setDispTkKaiyakuHr10(BizCurrency pDispTkKaiyakuHr10) {
        dispTkKaiyakuHr10 = pDispTkKaiyakuHr10;
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
        return vhsyuddisptkgannyukyhumu1;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu1(C_UmuKbn pVhsyudisptkgannyukyhumu1) {
        vhsyuddisptkgannyukyhumu1 = pVhsyudisptkgannyukyhumu1;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu2() {
        return vhsyuddisptkgannyukyhumu2;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu2(C_UmuKbn pVhsyudisptkgannyukyhumu2) {
        vhsyuddisptkgannyukyhumu2 = pVhsyudisptkgannyukyhumu2;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu3() {
        return vhsyuddisptkgannyukyhumu3;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu3(C_UmuKbn pVhsyudisptkgannyukyhumu3) {
        vhsyuddisptkgannyukyhumu3 = pVhsyudisptkgannyukyhumu3;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu4() {
        return vhsyuddisptkgannyukyhumu4;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu4(C_UmuKbn pVhsyudisptkgannyukyhumu4) {
        vhsyuddisptkgannyukyhumu4 = pVhsyudisptkgannyukyhumu4;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu5() {
        return vhsyuddisptkgannyukyhumu5;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu5(C_UmuKbn pVhsyudisptkgannyukyhumu5) {
        vhsyuddisptkgannyukyhumu5 = pVhsyudisptkgannyukyhumu5;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu6() {
        return vhsyuddisptkgannyukyhumu6;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu6(C_UmuKbn pVhsyudisptkgannyukyhumu6) {
        vhsyuddisptkgannyukyhumu6 = pVhsyudisptkgannyukyhumu6;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu7() {
        return vhsyuddisptkgannyukyhumu7;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu7(C_UmuKbn pVhsyudisptkgannyukyhumu7) {
        vhsyuddisptkgannyukyhumu7 = pVhsyudisptkgannyukyhumu7;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu8() {
        return vhsyuddisptkgannyukyhumu8;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu8(C_UmuKbn pVhsyudisptkgannyukyhumu8) {
        vhsyuddisptkgannyukyhumu8 = pVhsyudisptkgannyukyhumu8;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu9() {
        return vhsyuddisptkgannyukyhumu9;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu9(C_UmuKbn pVhsyudisptkgannyukyhumu9) {
        vhsyuddisptkgannyukyhumu9 = pVhsyudisptkgannyukyhumu9;
    }

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu10() {
        return vhsyuddisptkgannyukyhumu10;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu10(C_UmuKbn pVhsyudisptkgannyukyhumu10) {
        vhsyuddisptkgannyukyhumu10 = pVhsyudisptkgannyukyhumu10;
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
    public C_HknKknKbn getVhsyuhknKknKbn() {
        return vhsyuhknKknKbn;
    }

    @Override
    public void setVhsyuhknKknKbn(C_HknKknKbn pVhsyuhknKknKbn) {
        vhsyuhknKknKbn = pVhsyuhknKknKbn;
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
    public int getVhsyusyohinhanteikbn() {
        return vhsyusyohinhanteikbn;
    }

    @Override
    public void setVhsyusyohinhanteikbn(int pVhsyusyohinhanteikbn) {
        vhsyusyohinhanteikbn = pVhsyusyohinhanteikbn;
    }

    @Override
    public C_UmuKbn getVhsyumvatekiumu() {
        return vhsyumvatekiumu;
    }

    @Override
    public void setVhsyumvatekiumu(C_UmuKbn pVhsyumvatekiumu) {
        vhsyumvatekiumu = pVhsyumvatekiumu;
    }

    @Override
    public C_UmuKbn getVhsyusbhkuktumu() {
        return vhsyusbhkuktumu;
    }

    @Override
    public void setVhsyusbhkuktumu(C_UmuKbn pVhsyusbhkuktumu) {
        vhsyusbhkuktumu = pVhsyusbhkuktumu;
    }

    @Override
    public C_UmuKbn getVhsyusbkyuuhukinuktumu() {
        return vhsyusbkyuuhukinuktumu;
    }

    @Override
    public void setVhsyusbkyuuhukinuktumu(C_UmuKbn pVhsyusbkyuuhukinuktumu) {
        vhsyusbkyuuhukinuktumu = pVhsyusbkyuuhukinuktumu;
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

    @Override
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    @Override
    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    @Override
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Override
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }

    public Integer getSyusyouhnsdno() {
        return syusyouhnsdno;
    }

    public void setSyusyouhnsdno(Integer pSyusyouhnsdno) {
        syusyouhnsdno = pSyusyouhnsdno;
    }

    public Integer getSyukyksyouhnrenno() {
        return syukyksyouhnrenno;
    }

    public void setSyukyksyouhnrenno(Integer pSyukyksyouhnrenno) {
        syukyksyouhnrenno = pSyukyksyouhnrenno;
    }

    public String getSyuryouritusdno() {
        return syuryouritusdno;
    }

    public void setSyuryouritusdno(String pSyuryouritusdno) {
        syuryouritusdno = pSyuryouritusdno;
    }

    public BizNumber getSyuyoteiriritu() {
        return syuyoteiriritu;
    }

    public void setSyuyoteiriritu(BizNumber pSyuyoteiriritu) {
        syuyoteiriritu = pSyuyoteiriritu;
    }

    public C_UmuKbn getDispnewtknextkosumu1() {
        return dispnewtknextkosumu1;
    }

    public void setDispnewtknextkosumu1(C_UmuKbn pDispnewtknextkosumu1) {
        dispnewtknextkosumu1 = pDispnewtknextkosumu1;
    }

    public C_UmuKbn getDispnewtknextkosumu2() {
        return dispnewtknextkosumu2;
    }

    public void setDispnewtknextkosumu2(C_UmuKbn pDispnewtknextkosumu2) {
        dispnewtknextkosumu2 = pDispnewtknextkosumu2;
    }

    public C_UmuKbn getDispnewtknextkosumu3() {
        return dispnewtknextkosumu3;
    }

    public void setDispnewtknextkosumu3(C_UmuKbn pDispnewtknextkosumu3) {
        dispnewtknextkosumu3 = pDispnewtknextkosumu3;
    }

    public C_UmuKbn getDispnewtknextkosumu4() {
        return dispnewtknextkosumu4;
    }

    public void setDispnewtknextkosumu4(C_UmuKbn pDispnewtknextkosumu4) {
        dispnewtknextkosumu4 = pDispnewtknextkosumu4;
    }

    public C_UmuKbn getDispnewtknextkosumu5() {
        return dispnewtknextkosumu5;
    }

    public void setDispnewtknextkosumu5(C_UmuKbn pDispnewtknextkosumu5) {
        dispnewtknextkosumu5 = pDispnewtknextkosumu5;
    }

    public C_UmuKbn getDispnewtknextkosumu6() {
        return dispnewtknextkosumu6;
    }

    public void setDispnewtknextkosumu6(C_UmuKbn pDispnewtknextkosumu6) {
        dispnewtknextkosumu6 = pDispnewtknextkosumu6;
    }

    public C_UmuKbn getDispnewtknextkosumu7() {
        return dispnewtknextkosumu7;
    }

    public void setDispnewtknextkosumu7(C_UmuKbn pDispnewtknextkosumu7) {
        dispnewtknextkosumu7 = pDispnewtknextkosumu7;
    }

    public C_UmuKbn getDispnewtknextkosumu8() {
        return dispnewtknextkosumu8;
    }

    public void setDispnewtknextkosumu8(C_UmuKbn pDispnewtknextkosumu8) {
        dispnewtknextkosumu8 = pDispnewtknextkosumu8;
    }

    public C_UmuKbn getDispnewtknextkosumu9() {
        return dispnewtknextkosumu9;
    }

    public void setDispnewtknextkosumu9(C_UmuKbn pDispnewtknextkosumu9) {
        dispnewtknextkosumu9 = pDispnewtknextkosumu9;
    }

    public C_UmuKbn getDispnewtknextkosumu10() {
        return dispnewtknextkosumu10;
    }

    public void setDispnewtknextkosumu10(C_UmuKbn pDispnewtknextkosumu10) {
        dispnewtknextkosumu10 = pDispnewtknextkosumu10;
    }

    public Integer getTksyouhnsdno1() {
        return tksyouhnsdno1;
    }

    public void setTksyouhnsdno1(Integer pTksyouhnsdno1) {
        tksyouhnsdno1 = pTksyouhnsdno1;
    }

    public Integer getTksyouhnsdno2() {
        return tksyouhnsdno2;
    }

    public void setTksyouhnsdno2(Integer pTksyouhnsdno2) {
        tksyouhnsdno2 = pTksyouhnsdno2;
    }

    public Integer getTksyouhnsdno3() {
        return tksyouhnsdno3;
    }

    public void setTksyouhnsdno3(Integer pTksyouhnsdno3) {
        tksyouhnsdno3 = pTksyouhnsdno3;
    }

    public Integer getTksyouhnsdno4() {
        return tksyouhnsdno4;
    }

    public void setTksyouhnsdno4(Integer pTksyouhnsdno4) {
        tksyouhnsdno4 = pTksyouhnsdno4;
    }

    public Integer getTksyouhnsdno5() {
        return tksyouhnsdno5;
    }

    public void setTksyouhnsdno5(Integer pTksyouhnsdno5) {
        tksyouhnsdno5 = pTksyouhnsdno5;
    }

    public Integer getTksyouhnsdno6() {
        return tksyouhnsdno6;
    }

    public void setTksyouhnsdno6(Integer pTksyouhnsdno6) {
        tksyouhnsdno6 = pTksyouhnsdno6;
    }

    public Integer getTksyouhnsdno7() {
        return tksyouhnsdno7;
    }

    public void setTksyouhnsdno7(Integer pTksyouhnsdno7) {
        tksyouhnsdno7 = pTksyouhnsdno7;
    }

    public Integer getTksyouhnsdno8() {
        return tksyouhnsdno8;
    }

    public void setTksyouhnsdno8(Integer pTksyouhnsdno8) {
        tksyouhnsdno8 = pTksyouhnsdno8;
    }

    public Integer getTksyouhnsdno9() {
        return tksyouhnsdno9;
    }

    public void setTksyouhnsdno9(Integer pTksyouhnsdno9) {
        tksyouhnsdno9 = pTksyouhnsdno9;
    }

    public Integer getTksyouhnsdno10() {
        return tksyouhnsdno10;
    }

    public void setTksyouhnsdno10(Integer pTksyouhnsdno10) {
        tksyouhnsdno10 = pTksyouhnsdno10;
    }

    public Integer getTkkyksyouhnrenno1() {
        return tkkyksyouhnrenno1;
    }

    public void setTkkyksyouhnrenno1(Integer pTkkyksyouhnrenno1) {
        tkkyksyouhnrenno1 = pTkkyksyouhnrenno1;
    }

    public Integer getTkkyksyouhnrenno2() {
        return tkkyksyouhnrenno2;
    }

    public void setTkkyksyouhnrenno2(Integer pTkkyksyouhnrenno2) {
        tkkyksyouhnrenno2 = pTkkyksyouhnrenno2;
    }

    public Integer getTkkyksyouhnrenno3() {
        return tkkyksyouhnrenno3;
    }

    public void setTkkyksyouhnrenno3(Integer pTkkyksyouhnrenno3) {
        tkkyksyouhnrenno3 = pTkkyksyouhnrenno3;
    }

    public Integer getTkkyksyouhnrenno4() {
        return tkkyksyouhnrenno4;
    }

    public void setTkkyksyouhnrenno4(Integer pTkkyksyouhnrenno4) {
        tkkyksyouhnrenno4 = pTkkyksyouhnrenno4;
    }

    public Integer getTkkyksyouhnrenno5() {
        return tkkyksyouhnrenno5;
    }

    public void setTkkyksyouhnrenno5(Integer pTkkyksyouhnrenno5) {
        tkkyksyouhnrenno5 = pTkkyksyouhnrenno5;
    }

    public Integer getTkkyksyouhnrenno6() {
        return tkkyksyouhnrenno6;
    }

    public void setTkkyksyouhnrenno6(Integer pTkkyksyouhnrenno6) {
        tkkyksyouhnrenno6 = pTkkyksyouhnrenno6;
    }

    public Integer getTkkyksyouhnrenno7() {
        return tkkyksyouhnrenno7;
    }

    public void setTkkyksyouhnrenno7(Integer pTkkyksyouhnrenno7) {
        tkkyksyouhnrenno7 = pTkkyksyouhnrenno7;
    }

    public Integer getTkkyksyouhnrenno8() {
        return tkkyksyouhnrenno8;
    }

    public void setTkkyksyouhnrenno8(Integer pTkkyksyouhnrenno8) {
        tkkyksyouhnrenno8 = pTkkyksyouhnrenno8;
    }

    public Integer getTkkyksyouhnrenno9() {
        return tkkyksyouhnrenno9;
    }

    public void setTkkyksyouhnrenno9(Integer pTkkyksyouhnrenno9) {
        tkkyksyouhnrenno9 = pTkkyksyouhnrenno9;
    }

    public Integer getTkkyksyouhnrenno10() {
        return tkkyksyouhnrenno10;
    }

    public void setTkkyksyouhnrenno10(Integer pTkkyksyouhnrenno10) {
        tkkyksyouhnrenno10 = pTkkyksyouhnrenno10;
    }

    public int getKawaseRateMinasiKbn() {
        return kawaseRateMinasiKbn;
    }

    public void setKawaseRateMinasiKbn(int pKawaseRateMinasiKbn) {
        kawaseRateMinasiKbn = pKawaseRateMinasiKbn;
    }

    public int getUnitGkminasiKbn() {
        return unitGkminasiKbn;
    }

    public void setUnitGkminasiKbn(int pUnitGkminasiKbn) {
        unitGkminasiKbn = pUnitGkminasiKbn;
    }

    public C_SyorikekkaKbn getZenkaiSyoriKekka() {
        return zenkaiSyoriKekka;
    }

    public void setZenkaiSyoriKekka(C_SyorikekkaKbn pZenkaiSyoriKekka) {
        zenkaiSyoriKekka = pZenkaiSyoriKekka;
    }

    public C_ShrhousiteiKbn getShrhouSiteiKbn() {
        return shrhouSiteiKbn;
    }

    public void setShrhouSiteiKbn(C_ShrhousiteiKbn pShrhouSiteiKbn) {
        shrhouSiteiKbn = pShrhouSiteiKbn;
    }

    public BizCurrency getShrTsTmttkin() {
        return shrTsTmttkin;
    }

    public void setShrTsTmttkin(BizCurrency pShrTsTmttkin) {
        shrTsTmttkin = pShrTsTmttkin;
    }

    public BizCurrency getSjkkktyouseigk() {
        return sjkkktyouseigk;
    }

    public void setSjkkktyouseigk(BizCurrency pSjkkktyouseigk) {
        sjkkktyouseigk = pSjkkktyouseigk;
    }

    public BizNumber getKaiyakuSjkkkTyouseiriRitu() {
        return kaiyakuSjkkkTyouseiriRitu;
    }

    public void setKaiyakuSjkkkTyouseiriRitu(BizNumber pKaiyakuSjkkkTyouseiriRitu) {
        kaiyakuSjkkkTyouseiriRitu = pKaiyakuSjkkkTyouseiriRitu;
    }

    @Override
    public C_KhkinouModeIdKbn getKhkinouModeIdKbn() {
        return khkinouModeIdKbn;
    }

    public void setKhkinouModeIdKbn(C_KhkinouModeIdKbn pKhkinouModeIdKbn) {
        khkinouModeIdKbn = pKhkinouModeIdKbn;
    }

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn) {
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }

    public C_KykhnkKbn getPmnJtkHnkKbn() {
        return pmnJtkHnkKbn;
    }

    public void setPmnJtkHnkKbn(C_KykhnkKbn pPmnJtkHnkKbn) {
        pmnJtkHnkKbn = pPmnJtkHnkKbn;
    }

    public C_UmuKbn getYenShrTktekiUmu() {
        return yenShrTktekiUmu;
    }

    public void setYenShrTktekiUmu(C_UmuKbn pYenShrTktekiUmu) {
        yenShrTktekiUmu = pYenShrTktekiUmu;
    }

    @Override
    public String getBanknmkj() {
        return banknmkj;
    }

    @Override
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    @Override
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Override
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

    @Override
    public C_UmuKbn getNextkosumu() {
        return nextkosumu;
    }

    @Override
    public void setNextkosumu(C_UmuKbn pNextkosumu) {
        nextkosumu = pNextkosumu;
    }

    @Override
    public C_Tuukasyu getVhrkiyentkykwsratetuukasyu() {
        return vhrkiyentkykwsratetuukasyu;
    }

    @Override
    public void setVhrkiyentkykwsratetuukasyu(C_Tuukasyu pVhrkiyentkykwsratetuukasyu) {
        vhrkiyentkykwsratetuukasyu = pVhrkiyentkykwsratetuukasyu;
    }

    public C_KahiKbn getSyukkyPgengakuKahiKbn() {
        return syukkyPgengakuKahiKbn;
    }

    public void setSyukkyPgengakuKahiKbn(C_KahiKbn pSyukkyPgengakuKahiKbn) {
        syukkyPgengakuKahiKbn = pSyukkyPgengakuKahiKbn;
    }

    public BizNumber getSyukkyKyksjKkkTyouseiriRitu() {
        return syukkyKyksjKkkTyouseiriRitu;
    }

    public void setSyukkyKyksjKkkTyouseiriRitu(BizNumber pSyukkyKyksjKkkTyouseiriRitu) {
        syukkyKyksjKkkTyouseiriRitu = pSyukkyKyksjKkkTyouseiriRitu;
    }

    public BizCurrency getHtykeihiYen() {
        return htykeihiYen;
    }

    public void setHtykeihiYen(BizCurrency pHtykeihiYen) {
        htykeihiYen = pHtykeihiYen;
    }

    public C_HtsiryosyuKbn getShrTysySyuruiKbn() {
        return shrTysySyuruiKbn;
    }

    public void setShrTysySyuruiKbn(C_HtsiryosyuKbn pShrTysySyuruiKbn) {
        shrTysySyuruiKbn = pShrTysySyuruiKbn;
    }

    public int getFbSoukinEdaNo() {
        return fbSoukinEdaNo;
    }

    public void setFbSoukinEdaNo(int pFbSoukinEdaNo) {
        fbSoukinEdaNo = pFbSoukinEdaNo;
    }

    public String getSosikiCd() {
        return sosikiCd;
    }

    public void setSosikiCd(String pSosikiCd) {
        sosikiCd = pSosikiCd;
    }

    public String getDenrenNo() {
        return denrenNo;
    }

    public void setDenrenNo(String pDenrenNo) {
        denrenNo = pDenrenNo;
    }

    public CommonSiwakeOutBean getCommonSiwakeOutBean() {
        return commonSiwakeOutBean;
    }

    public void setCommonSiwakeOutBean(CommonSiwakeOutBean pCommonSiwakeOutBean) {
        commonSiwakeOutBean = pCommonSiwakeOutBean;
    }

    public BizDate getTienrisoKukisanYmd() {
        return tienrisoKukisanYmd;
    }

    public void setTienrisoKukisanYmd(BizDate pTienrisoKukisanYmd) {
        tienrisoKukisanYmd = pTienrisoKukisanYmd;
    }

    public Integer getTienrskNissuu() {
        return tienrskNissuu;
    }

    public void setTienrskNissuu(Integer pTienrskNissuu) {
        tienrskNissuu = pTienrskNissuu;
    }

    public BizDate getJpyTienrisoKukisanYmd() {
        return jpyTienrisoKukisanYmd;
    }

    public void setJpyTienrisoKukisanYmd(BizDate pJpyTienrisoKukisanYmd) {
        jpyTienrisoKukisanYmd = pJpyTienrisoKukisanYmd;
    }

    public Integer getJpyTienrskNissuu() {
        return jpyTienrskNissuu;
    }

    public void setJpyTienrskNissuu(Integer pJpyTienrskNissuu) {
        jpyTienrskNissuu = pJpyTienrskNissuu;
    }

    public BizNumber getSjkkktyouseirt() {
        return sjkkktyouseirt;
    }

    public void setSjkkktyouseirt(BizNumber pSjkkktyouseirt) {
        sjkkktyouseirt = pSjkkktyouseirt;
    }

    public boolean isInputMode() {

        boolean syorikngn = C_KhkinouModeIdKbn.INPUT.toString().equals(kinouMode.getKinouMode());

        return syorikngn;
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanPram);
        }

        super.setSyoruiInfoList(syoruiInfoList);
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(
        List<ProgressHistoryDataSourceBeanCommonParam> pProgresshistoryinfo) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfo = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : pProgresshistoryinfo) {
            progresshistoryinfo.add((ProgresshistoryinfoDataSourceBean) beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfo);
    }

    @Override
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanParam : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean) beanParam);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfo = Lists.newArrayList();
        for (KikeiyakuInfoDataSourceBeanCommonParam beanParam : pKikeiyakuInfo) {
            kikeiyakuInfo.add((KikeiyakuInfoDataSourceBean) beanParam);
        }
        super.setKikeiyakuInfo(kikeiyakuInfo);
    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {
        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(
        List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaiInfo = Lists.newArrayList();
        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pNenkinsiharaiInfo) {
            nenkinsiharaiInfo.add((NenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setNenkinsiharaiInfo(nenkinsiharaiInfo);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfo = Lists.newArrayList();
        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanParam : pPalkikeiyakuInfo) {
            palkikeiyakuInfo.add((PalkikeiyakuInfoDataSourceBean) beanParam);
        }
        super.setPalkikeiyakuInfo(palkikeiyakuInfo);
    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {
        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(
        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pPalNenkinsiharaiInfo) {
            palnenkinsiharaiInfo.add((PalnenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setPalnenkinsiharaiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {
        List<PalsueokiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalsueokiInfoDataSourceBeanCommonParam beanParam : pPalsueokiInfo) {
            palnenkinsiharaiInfo.add((PalsueokiInfoDataSourceBean) beanParam);
        }
        super.setPalsueokiInfo(palnenkinsiharaiInfo);
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

    @Override
    public C_UmuKbn getYennykntkhkumu() {
        return yennykntkhkumu;
    }

    @Override
    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu) {
        yennykntkhkumu = pYennykntkhkumu;
    }

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        this.kyktuukasyu = pKyktuukasyu;
    }

    public int getKykHnkKaisuu() {
        return kykHnkKaisuu;
    }

    public void setKykHnkKaisuu(int pKykHnkKaisuu) {
        this.kykHnkKaisuu = pKykHnkKaisuu;
    }

    public BizDate getYendtHnkYmd() {
        return yendtHnkYmd;
    }

    public void setYendtHnkYmd(BizDate pYendtHnkYmd) {
        this.yendtHnkYmd = pYendtHnkYmd;
    }

    public C_UmuKbn getGsBunriTaisyou() {
        return gsBunriTaisyou;
    }

    public void setGsBunriTaisyou(C_UmuKbn pGsBunriTaisyou) {
        this.gsBunriTaisyou = pGsBunriTaisyou;
    }

    public int getSyouhinHanteiKbn() {
        return syouhinHanteiKbn;
    }

    public void setSyouhinHanteiKbn(int pSyouhinHanteiKbn) {
        this.syouhinHanteiKbn = pSyouhinHanteiKbn;
    }

    public BizNumber getGengakuWariai() {
        return gengakuWariai;
    }

    public void setGengakuWariai(BizNumber pGengakuWariai) {
        this.gengakuWariai = pGengakuWariai;
    }

    public BizCurrency getTeirituTmttkngk() {
        return teirituTmttkngk;
    }

    public void setTeirituTmttkngk(BizCurrency pTeirituTmttkngk) {
        this.teirituTmttkngk = pTeirituTmttkngk;
    }

    public BizCurrency getSisuuRendouTmttkngk() {
        return sisuuRendouTmttkngk;
    }

    public void setSisuuRendouTmttkngk(BizCurrency pSisuuRendouTmttkngk) {
        this.sisuuRendouTmttkngk = pSisuuRendouTmttkngk;
    }

    public BizCurrency getKaiyakuKjgk() {
        return kaiyakuKjgk;
    }

    public void setKaiyakuKjgk(BizCurrency pKaiyakuKjgk) {
        this.kaiyakuKjgk = pKaiyakuKjgk;
    }

    public BizNumber getKaiyakuKoujyoritu() {
        return kaiyakuKoujyoritu;
    }

    public void setKaiyakuKoujyoritu(BizNumber pKaiyakuKoujyoritu) {
        this.kaiyakuKoujyoritu = pKaiyakuKoujyoritu;
    }

    public C_UmuKbn getGaikaGsBunriTaisyouFlag() {
        return gaikaGsBunriTaisyouFlag;
    }

    public void setGaikaGsBunriTaisyouFlag(C_UmuKbn pGaikaGsBunriTaisyouFlag) {
        this.gaikaGsBunriTaisyouFlag = pGaikaGsBunriTaisyouFlag;
    }

    public C_UmuKbn getYenkaGsBunriTaisyouFlag() {
        return yenkaGsBunriTaisyouFlag;
    }

    public void setYenkaGsBunriTaisyouFlag(C_UmuKbn pYenkaGsBunriTaisyouFlag) {
        this.yenkaGsBunriTaisyouFlag = pYenkaGsBunriTaisyouFlag;
    }

    public BizCurrency getGsTsZeigk() {
        return gsTsZeigk;
    }

    public void setGsTsZeigk(BizCurrency pGsTsZeigk) {
        this.gsTsZeigk = pGsTsZeigk;
    }

    public BizCurrency getGaikaShrYenGsTsZeigk() {
        return gaikaShrYenGsTsZeigk;
    }

    public void setGaikaShrYenGsTsZeigk(BizCurrency pGaikaShrYenGsTsZeigk) {
        this.gaikaShrYenGsTsZeigk = pGaikaShrYenGsTsZeigk;
    }

    public BizCurrency getGaikaShrYenGsTsZeigkNationaltax() {
        return gaikaShrYenGsTsZeigkNationaltax;
    }

    public void setGaikaShrYenGsTsZeigkNationaltax(BizCurrency pGaikaShrYenGsTsZeigkNationaltax) {
        this.gaikaShrYenGsTsZeigkNationaltax = pGaikaShrYenGsTsZeigkNationaltax;
    }

    public BizCurrency getYenkaShrYenGsTsZeigkNationaltax() {
        return yenkaShrYenGsTsZeigkNationaltax;
    }

    public void setYenkaShrYenGsTsZeigkNationaltax(BizCurrency pYenkaShrYenGsTsZeigkNationaltax) {
        this.yenkaShrYenGsTsZeigkNationaltax = pYenkaShrYenGsTsZeigkNationaltax;
    }

    public BizCurrency getGaikaShrYenGsTsZeigkLocaltax() {
        return gaikaShrYenGsTsZeigkLocaltax;
    }

    public void setGaikaShrYenGsTsZeigkLocaltax(BizCurrency pGaikaShrYenGsTsZeigkLocaltax) {
        this.gaikaShrYenGsTsZeigkLocaltax = pGaikaShrYenGsTsZeigkLocaltax;
    }

    public BizCurrency getYenkaShrYenGsTsZeigkLocaltax() {
        return yenkaShrYenGsTsZeigkLocaltax;
    }

    public void setYenkaShrYenGsTsZeigkLocaltax(BizCurrency pYenkaShrYenGsTsZeigkLocaltax) {
        this.yenkaShrYenGsTsZeigkLocaltax = pYenkaShrYenGsTsZeigkLocaltax;
    }

    public BizCurrency getGaikaShrYenGsTsTaisyouSaeki() {
        return gaikaShrYenGsTsTaisyouSaeki;
    }

    public void setGaikaShrYenGsTsTaisyouSaeki(BizCurrency pGaikaShrYenGsTsTaisyouSaeki) {
        this.gaikaShrYenGsTsTaisyouSaeki = pGaikaShrYenGsTsTaisyouSaeki;
    }

    public BizCurrency getYenkaShrYenGsTsTaisyouSaeki() {
        return yenkaShrYenGsTsTaisyouSaeki;
    }

    public void setYenkaShrYenGsTsTaisyouSaeki(BizCurrency pYenkaShrYenGsTsTaisyouSaeki) {
        this.yenkaShrYenGsTsTaisyouSaeki = pYenkaShrYenGsTsTaisyouSaeki;
    }

    public BizCurrency getYendthnkgstszeigk() {
        return yendthnkgstszeigk;
    }

    public void setYendthnkgstszeigk(BizCurrency pYendthnkgstszeigk) {
        this.yendthnkgstszeigk = pYendthnkgstszeigk;
    }

    public BizCurrency getYendthnkGstsTaisyouSaeki() {
        return yendthnkGstsTaisyouSaeki;
    }

    public void setYendthnkGstsTaisyouSaeki(BizCurrency pYendthnkGstsTaisyouSaeki) {
        this.yendthnkGstsTaisyouSaeki = pYendthnkGstsTaisyouSaeki;
    }

    public BizCurrency getKeisanKhYenW() {
        return keisanKhYenW;
    }

    public void setKeisanKhYenW(BizCurrency pKeisanKhYenW) {
        this.keisanKhYenW = pKeisanKhYenW;
    }

    public BizCurrency getGaikaShrYenHtyKeihi() {
        return gaikaShrYenHtyKeihi;
    }

    public void setGaikaShrYenHtyKeihi(BizCurrency pGaikaShrYenHtyKeihi) {
        this.gaikaShrYenHtyKeihi = pGaikaShrYenHtyKeihi;
    }

    public BizCurrency getYenkaShrYenHtyKeihi() {
        return yenkaShrYenHtyKeihi;
    }

    public void setYenkaShrYenHtyKeihi(BizCurrency pYenkaShrYenHtyKeihi) {
        this.yenkaShrYenHtyKeihi = pYenkaShrYenHtyKeihi;
    }

    public C_RatesyutokukekkaKbn getZeimuRatesyutokukekkaKbn() {
        return zeimuRatesyutokukekkaKbn;
    }

    public void setZeimuRatesyutokukekkaKbn(C_RatesyutokukekkaKbn pZeimuRatesyutokukekkaKbn) {
        this.zeimuRatesyutokukekkaKbn = pZeimuRatesyutokukekkaKbn;
    }

    public C_UmuKbn getGsBunriTaisyouFlag() {
        return gsBunriTaisyouFlag;
    }

    public void setGsBunriTaisyouFlag(C_UmuKbn pGsBunriTaisyouFlag) {
        this.gsBunriTaisyouFlag = pGsBunriTaisyouFlag;
    }

    public BizDate getYendtTienRskKsnbi() {
        return yendtTienRskKsnbi;
    }

    public void setYendtTienRskKsnbi(BizDate pYendtTienRskKsnbi) {
        this.yendtTienRskKsnbi = pYendtTienRskKsnbi;
    }

    public Integer getYendtTienRskNissuu() {
        return yendtTienRskNissuu;
    }

    public void setYendtTienRskNissuu(Integer pYendtTienRskNissuu) {
        this.yendtTienRskNissuu = pYendtTienRskNissuu;
    }

    public BizCurrency getJpyGsTszeigk() {
        return jpyGsTszeigk;
    }

    public void setJpyGsTszeigk(BizCurrency pJpyGsTszeigk) {
        this.jpyGsTszeigk = pJpyGsTszeigk;
    }

    public BizDate getSksSakuseiYmd() {
        return sksSakuseiYmd;
    }

    public void setSksSakuseiYmd(BizDate pSksSakuseiYmd) {
        this.sksSakuseiYmd = pSksSakuseiYmd;
    }

    public C_UmuKbn getZeiseitkkktkykhukaumu() {
        return zeiseitkkktkykhukaumu;
    }

    public void setZeiseitkkktkykhukaumu(C_UmuKbn pZeiseitkkktkykhukaumu) {
        zeiseitkkktkykhukaumu = pZeiseitkkktkykhukaumu;
    }

    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }
    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        this.hrktuukasyu = pHrktuukasyu;
    }

    public BizCurrency getPtmttkngk() {
        return ptmttkngk;
    }

    public void setPtmttkngk(BizCurrency pPtmttkngk) {
        this.ptmttkngk = pPtmttkngk;
    }

    public BizCurrency getKihrkmpstgk() {
        return kihrkmpstgk;
    }

    public void setKihrkmpstgk(BizCurrency pKihrkmpstgk) {
        this.kihrkmpstgk = pKihrkmpstgk;
    }

    public BizDateYM getTmttkntaisyouym() {
        return tmttkntaisyouym;
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouym) {
        this.tmttkntaisyouym = pTmttkntaisyouym;
    }

    public BizCurrency getNewZennoujihrkp() {
        return newZennoujihrkp;
    }

    public void setNewZennoujihrkp(BizCurrency pNewZennoujihrkp) {
        this.newZennoujihrkp = pNewZennoujihrkp;
    }

    public BizCurrency getNewZennounyuukinkgk() {
        return newZennounyuukinkgk;
    }

    public void setNewZennounyuukinkgk(BizCurrency pNewZennounyuukinkgk) {
        this.newZennounyuukinkgk = pNewZennounyuukinkgk;
    }

    public BizCurrency getMikeikaP() {
        return mikeikaP;
    }

    public void setMikeikaP(BizCurrency pMikeikaP) {
        this.mikeikaP = pMikeikaP;
    }

    public int getMikeikaPJyutouKaisuuY() {
        return mikeikaPJyutouKaisuuY;
    }

    public void setMikeikaPJyutouKaisuuY(int pMikeikaPJyutouKaisuuY) {
        this.mikeikaPJyutouKaisuuY = pMikeikaPJyutouKaisuuY;
    }

    public int getMikeikaPJyutouKaisuuM() {
        return mikeikaPJyutouKaisuuM;
    }

    public void setMikeikaPJyutouKaisuuM(int pMikeikaPJyutouKaisuuM) {
        this.mikeikaPJyutouKaisuuM = pMikeikaPJyutouKaisuuM;
    }

    public BizCurrency getKariwariatedruigk() {
        return kariwariatedruigk;
    }

    public void setKariwariatedruigk(BizCurrency pKariwariatedruigk) {
        this.kariwariatedruigk = pKariwariatedruigk;
    }

    public BizCurrency getKariwariatedgngkkngk() {
        return kariwariatedgngkkngk;
    }

    public void setKariwariatedgngkkngk(BizCurrency pKariwariatedgngkkngk) {
        this.kariwariatedgngkkngk = pKariwariatedgngkkngk;
    }

    public BizCurrency getKariwariatedshrgk() {
        return kariwariatedshrgk;
    }

    public void setKariwariatedshrgk(BizCurrency pKariwariatedshrgk) {
        this.kariwariatedshrgk = pKariwariatedshrgk;
    }

    public KhHaitouKanriKeyinfoBean getKhHaitouKanriKeyinfoBean() {
        return khHaitouKanriKeyinfoBean;
    }

    public void setKhHaitouKanriKeyinfoBean(KhHaitouKanriKeyinfoBean pKhHaitouKanriKeyinfoBean) {
        this.khHaitouKanriKeyinfoBean = pKhHaitouKanriKeyinfoBean;
    }

    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {
        return editDshrTukiDKoumokuBean;
    }

    public void setEditDshrTukiDKoumokuBean(EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean) {
        this.editDshrTukiDKoumokuBean = pEditDshrTukiDKoumokuBean;
    }

    public BizCurrency getYensonotashrgk() {
        return yensonotashrgk;
    }

    public void setYensonotashrgk(BizCurrency pYensonotashrgk) {
        this.yensonotashrgk = pYensonotashrgk;
    }

    public BizCurrency getHituyoukeihiitijisytktysgk() {
        return hituyoukeihiitijisytktysgk;
    }

    public void setHituyoukeihiitijisytktysgk(BizCurrency pHituyoukeihiitijisytktysgk) {
        this.hituyoukeihiitijisytktysgk = pHituyoukeihiitijisytktysgk;
    }

    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        this.zennouseisankgk = pZennouseisankgk;
    }

    public ZennouKoujyogakuKeisanParam getZennouKoujyogakuKeisanParam() {
        return zennouKoujyogakuKeisanParam;
    }

    public void setZennouKoujyogakuKeisanParam(ZennouKoujyogakuKeisanParam pZennouKoujyogakuKeisanParam) {
        zennouKoujyogakuKeisanParam = pZennouKoujyogakuKeisanParam;
    }

    public ZennouKoujyogakuKeisanParam getHenmaeZennouKoujyogakuKeisanParam() {
        return henmaeZennouKoujyogakuKeisanParam;
    }

    public void setHenmaeZennouKoujyogakuKeisanParam(ZennouKoujyogakuKeisanParam pHenmaeZennouKoujyogakuKeisanParam) {
        henmaeZennouKoujyogakuKeisanParam = pHenmaeZennouKoujyogakuKeisanParam;
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    public BizCurrency getPtumitatekinTyoseimae() {
        return ptumitatekinTyoseimae;
    }

    public void setPtumitatekinTyoseimae(BizCurrency pPtumitatekinTyoseimae) {
        this.ptumitatekinTyoseimae = pPtumitatekinTyoseimae;
    }

    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    public MiKeikaPBean[] getMiKeikaPBeans() {
        return miKeikaPBeans;
    }

    public void setMiKeikaPBeans(MiKeikaPBean[] pMiKeikaPBeans) {
        this.miKeikaPBeans = pMiKeikaPBeans;
    }

    public BizCurrency getKihrkpssrrkyenkansanhenkankin() {
        return kihrkpssrrkyenkansanhenkankin;
    }

    public void setKihrkpssrrkyenkansanhenkankin(BizCurrency pKihrkpssrrkyenkansanhenkankin) {
        this.kihrkpssrrkyenkansanhenkankin = pKihrkpssrrkyenkansanhenkankin;
    }

    public C_UmuKbn getMihaneiDUmu() {
        return mihaneiDUmu;
    }

    public void setMihaneiDUmu(C_UmuKbn pmihaneiDUmu) {
        mihaneiDUmu = pmihaneiDUmu;
    }

    public C_UmuKbn getZennouMijyuutouFlg() {
        return zennouMijyuutouFlg;
    }

    public void setZennouMijyuutouFlg(C_UmuKbn pZennouMijyuutouFlg) {
        this.zennouMijyuutouFlg = pZennouMijyuutouFlg;
    }

    public C_UmuKbn getZennouJyutouTorikesiFlg() {
        return zennouJyutouTorikesiFlg;
    }

    public void setZennouJyutouTorikesiFlg(C_UmuKbn pZennouJyutouTorikesiFlg) {
        this.zennouJyutouTorikesiFlg = pZennouJyutouTorikesiFlg;
    }

    public BizDateYM getLastPJyuutouYm() {
        return lastPJyuutouYm;
    }

    public void setLastPJyuutouYm(BizDateYM pLastPJyuutouYm) {
        this.lastPJyuutouYm = pLastPJyuutouYm;
    }

    public BizCurrency getSaeki() {
        return saeki;
    }

    public void setSaeki(BizCurrency pSaeki) {
        this.saeki = pSaeki;
    }

    public C_UmuKbn getMynoSinkokuTaisyouFlg() {
        return mynoSinkokuTaisyouFlg;
    }

    public void setMynoSinkokuTaisyouFlg(C_UmuKbn pMynoSinkokuTaisyouFlg) {
        this.mynoSinkokuTaisyouFlg = pMynoSinkokuTaisyouFlg;
    }

    public String getPatternSoukinsakikbn() {
        return patternSoukinsakikbn;
    }

    public void setPatternSoukinsakikbn(String pPatternSoukinsakikbn) {
        this.patternSoukinsakikbn = pPatternSoukinsakikbn;
    }

    public C_UmuKbn getHeijyunbaraiumu() {
        return heijyunbaraiumu;
    }

    public void setHeijyunbaraiumu(C_UmuKbn pHeijyunbaraiumu) {
        heijyunbaraiumu = pHeijyunbaraiumu;
    }

    public C_UmuKbn getItijibrumu() {
        return itijibrumu;
    }

    public void setItijibrumu(C_UmuKbn pItijibrumu) {
        itijibrumu = pItijibrumu;
    }

    public C_HijynbrKanritukaHantKbn getHijynbrKanritukaHantKbn() {
        return hijynbrKanritukaHantKbn;
    }

    public void setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn pHijynbrKanritukaHantKbn) {
        this.hijynbrKanritukaHantKbn = pHijynbrKanritukaHantKbn;
    }

    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        this.rstuukasyu = pRstuukasyu;
    }

    public BizCurrency getMikeikapGengakuMae() {
        return mikeikapGengakuMae;
    }

    public void setMikeikapGengakuMae(BizCurrency pMikeikapGengakuMae) {
        this.mikeikapGengakuMae = pMikeikapGengakuMae;
    }

    public BizCurrency getMikeikapGengakuGo() {
        return mikeikapGengakuGo;
    }

    public void setMikeikapGengakuGo(BizCurrency pMikeikapGengakuGo) {
        this.mikeikapGengakuGo = pMikeikapGengakuGo;
    }

    public BizCurrency getZennouseisankinGengakuMae() {
        return zennouseisankinGengakuMae;
    }

    public void setZennouseisankinGengakuMae(BizCurrency pZennouseisankinGengakuMae) {
        this.zennouseisankinGengakuMae = pZennouseisankinGengakuMae;
    }

    public BizCurrency getZennouseisankinGengakuGo() {
        return zennouseisankinGengakuGo;
    }

    public void setZennouseisankinGengakuGo(BizCurrency pZennouseisankinGengakuGo) {
        this.zennouseisankinGengakuGo = pZennouseisankinGengakuGo;
    }

    public BizCurrency getZennounyuukinkgkrstk() {
        return zennounyuukinkgkrstk;
    }

    public void setZennounyuukinkgkrstk(BizCurrency pZennounyuukinkgkrstk) {
        this.zennounyuukinkgkrstk = pZennounyuukinkgkrstk;
    }

    public BizNumber getZennounyuukinkgkryosyukwsrate() {
        return zennounyuukinkgkryosyukwsrate;
    }

    public void setZennounyuukinkgkryosyukwsrate(BizNumber pZennounyuukinkgkryosyukwsrate) {
        this.zennounyuukinkgkryosyukwsrate = pZennounyuukinkgkryosyukwsrate;
    }

    public BizDate getZennounyuukinkgkryosyukwsratekjymd() {
        return zennounyuukinkgkryosyukwsratekjymd;
    }

    public void setZennounyuukinkgkryosyukwsratekjymd(BizDate pZennounyuukinkgkryosyukwsratekjymd) {
        this.zennounyuukinkgkryosyukwsratekjymd = pZennounyuukinkgkryosyukwsratekjymd;
    }

    public BizCurrency getYenkansannyknkingk() {
        return yenkansannyknkingk;
    }

    public void setYenkansannyknkingk(BizCurrency pYenkansannyknkingk) {
        this.yenkansannyknkingk = pYenkansannyknkingk;
    }

    public BizNumber getYenkansannyknkingkryosyukwsrate() {
        return yenkansannyknkingkryosyukwsrate;
    }

    public void setYenkansannyknkingkryosyukwsrate(BizNumber pYenkansannyknkingkryosyukwsrate) {
        this.yenkansannyknkingkryosyukwsrate = pYenkansannyknkingkryosyukwsrate;
    }

    public BizDate getYenkansannyknkingkryosyukwsratekjymd() {
        return yenkansannyknkingkryosyukwsratekjymd;
    }

    public void setYenkansannyknkingkryosyukwsratekjymd(BizDate pYenkansannyknkingkryosyukwsratekjymd) {
        this.yenkansannyknkingkryosyukwsratekjymd = pYenkansannyknkingkryosyukwsratekjymd;
    }

    public BizCurrency getKaiyakuhrkngkkeisiteituuka() {
        return kaiyakuhrkngkkeisiteituuka;
    }

    public void setKaiyakuhrkngkkeisiteituuka(BizCurrency pKaiyakuhrkngkkeisiteituuka) {
        kaiyakuhrkngkkeisiteituuka = pKaiyakuhrkngkkeisiteituuka;
    }

    public BizCurrency getJpykaiyakuhr() {
        return jpykaiyakuhr;
    }

    public void setJpykaiyakuhr(BizCurrency pJpykaiyakuhr) {
        this.jpykaiyakuhr = pJpykaiyakuhr;
    }

    @Override
    public KariukekinInfoDataSourceBeanCommonParam createKariukekinInfoDataSourceBean() {
        return new KariukekinInfoDataSourceBean();
    }

    @Override
    public void convertKariukekinInfoForCommonParam(List<KariukekinInfoDataSourceBeanCommonParam> pKariukekinInfo) {
        List<KariukekinInfoDataSourceBean> kariukekinInfo = Lists.newArrayList();
        for (KariukekinInfoDataSourceBeanCommonParam dataSourceBeanCommonParam :pKariukekinInfo) {
            kariukekinInfo.add((KariukekinInfoDataSourceBean)dataSourceBeanCommonParam);
        }
        super.setKariukekinInfo(kariukekinInfo);
    }
}
