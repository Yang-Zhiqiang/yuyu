package yuyu.app.hozen.khozen.khdshr;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 配当金支払 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhDShrConstants {

    public static final int PAGENO_INIT           = 1;

    public static final int PAGENO_INPUTKEY       = 1;

    public static final int PAGENO_INPUTCONTENTS  = 2;

    public static final int PAGENO_REFERENCE      = 3;

    public static final int PAGENO_CONFIRM        = 4;

    public static final int PAGENO_RESULT         = 5;

    public static final int PAGENO_SKSCONFIRM     = 6;

    public static final int PAGENO_SKSRESULT      = 7;

    static final String FORWARDNAME_INIT           = "init";

    static final String FORWARDNAME_INPUTKEY       = "InputKey";

    static final String FORWARDNAME_INPUTCONTENTS  = "InputContents";

    static final String FORWARDNAME_REFERENCE      = "Reference";

    static final String FORWARDNAME_CONFIRM        = "Confirm";

    static final String FORWARDNAME_RESULT         = "Result";

    static final String FORWARDNAME_SKSCONFIRM     = "SksConfirm";

    static final String FORWARDNAME_SKSRESULT      = "SksResult";

    static final String FORWARDNAME_BACKTOWORKLIST = "backToWorkList";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khdshr", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPJIMUTETUZUKINM = new Item("khdshr", "kouteiinfo", "vktifdispjimutetuzukinm", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPTASKNM = new Item("khdshr", "kouteiinfo", "vktifdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_VKIHNSYONO = new Item("khdshr", "kihonInfo", "vkihnsyono", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_VKIHNYUUKOUSYOUMETUKBN = new Item("khdshr", "kihonInfo", "vkihnyuukousyoumetukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_VKIHNKYKJYOUTAI = new Item("khdshr", "kihonInfo", "vkihnkykjyoutai", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_VKIHNSYOUMETUJIYUU = new Item("khdshr", "kihonInfo", "vkihnsyoumetujiyuu", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_VKIHNSYOUMETUYMD = new Item("khdshr", "kihonInfo", "vkihnsyoumetuymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_VKIHNLASTSYOSAIHKYMD = new Item("khdshr", "kihonInfo", "vkihnlastsyosaihkymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_SYORUITTYKYMDTIME = new Item("khdshr", "syoruiInfoList", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_SYORUINM = new Item("khdshr", "syoruiInfoList", "syoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HTYSYORUIUMUKBN = new Item("khdshr", "syoruiInfoList", "htysyoruiumukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINK = new Item("khdshr", "syoruiInfoList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINKFLG = new Item("khdshr", "syoruiInfoList", "hyoujilinkflg", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_IMAGEID = new Item("khdshr", "syoruiInfoList", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLHYOUJI_ALLHYOUJIBTN = new Item("khdshr", "buttonAllhyouji", "allhyoujibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENGROUP_IMAGEID = new Item("khdshr", "hiddenGroup", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_TETUDUKITYUUIINFO_VTDKTKKTYUITAKBN = new Item("khdshr", "tetudukityuuiInfo", "vtdktkktyuitakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_TETUDUKITYUUIINFO_VTDKTTTDKTYUUINAIYOU1 = new Item("khdshr", "tetudukityuuiInfo", "vtdktttdktyuuinaiyou1", null, ErrorMsgKbn.DD);

    static final Item DDID_TETUDUKITYUUIINFO_VTDKTTTDKTYUUINAIYOU2 = new Item("khdshr", "tetudukityuuiInfo", "vtdktttdktyuuinaiyou2", null, ErrorMsgKbn.DD);

    static final Item DDID_TETUDUKITYUUIINFO_VTDKTTTDKTYUUINAIYOU3 = new Item("khdshr", "tetudukityuuiInfo", "vtdktttdktyuuinaiyou3", null, ErrorMsgKbn.DD);

    static final Item DDID_TTDKTYUUIKBNINFO_VTDKTTTDKTYUUIKBN = new Item("khdshr", "ttdktyuuikbnInfo", "vtdktttdktyuuikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_TTDKTYUUIKBNINFO_VTDKTTTDKTYIKBNHSKNAIYOU = new Item("khdshr", "ttdktyuuikbnInfo", "vtdktttdktyikbnhsknaiyou", null, ErrorMsgKbn.DD);

    static final Item DDID_TTDKTYUUIKBNINFO_VTDKTTTDKTYUUIKBNSETYMD = new Item("khdshr", "ttdktyuuikbnInfo", "vtdktttdktyuuikbnsetymd", null, ErrorMsgKbn.DD);

    static final Item DDID_TTDKTYUUIKBNINFO_VTDKTSETSOSIKINM = new Item("khdshr", "ttdktyuuikbnInfo", "vtdktsetsosikinm", null, ErrorMsgKbn.DD);

    static final Item DDID_STKNSETINFO_VTDKTSTKNSETKBN = new Item("khdshr", "stknsetInfo", "vtdktstknsetkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPSYORIYMD1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispsyoriymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPFATCASNSIKBN1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispfatcasnsikbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPBIKKJNSSINFOKBN1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispbikkjnssinfokbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPFATCAKEKKBN1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispfatcakekkbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPFATCAHANKEIIKBN1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispfatcahankeiikbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPBIKKNZSYNO1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispbikknzsyno1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPSYOMEIYMD1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispsyomeiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPFATCATGKBN1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispfatcatgkbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPNMKN1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispnmkn1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPNMKJ1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispnmkj1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPSEIYMD1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispseiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPSEI1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispsei1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO1_VTDKTDISPKOURYOKUENDYMD1 = new Item("khdshr", "dispFatcaInfo1", "vtdktdispkouryokuendymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPSYORIYMD2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispsyoriymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPFATCASNSIKBN2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispfatcasnsikbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPBIKKJNSSINFOKBN2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispbikkjnssinfokbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPFATCAKEKKBN2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispfatcakekkbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPFATCAHANKEIIKBN2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispfatcahankeiikbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPBIKKNZSYNO2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispbikknzsyno2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPSYOMEIYMD2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispsyomeiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPFATCATGKBN2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispfatcatgkbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPNMKN2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispnmkn2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPNMKJ2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispnmkj2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPSEIYMD2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispseiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPSEI2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispsei2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO2_VTDKTDISPKOURYOKUENDYMD2 = new Item("khdshr", "dispFatcaInfo2", "vtdktdispkouryokuendymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPSYORIYMD3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispsyoriymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPFATCASNSIKBN3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispfatcasnsikbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPBIKKJNSSINFOKBN3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispbikkjnssinfokbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPFATCAKEKKBN3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispfatcakekkbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPFATCAHANKEIIKBN3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispfatcahankeiikbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPBIKKNZSYNO3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispbikknzsyno3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPSYOMEIYMD3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispsyomeiymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPFATCATGKBN3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispfatcatgkbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPNMKN3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispnmkn3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPNMKJ3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispnmkj3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPSEIYMD3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispseiymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPSEI3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispsei3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO3_VTDKTDISPKOURYOKUENDYMD3 = new Item("khdshr", "dispFatcaInfo3", "vtdktdispkouryokuendymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPSYORIYMD4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispsyoriymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPFATCASNSIKBN4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispfatcasnsikbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPBIKKJNSSINFOKBN4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispbikkjnssinfokbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPFATCAKEKKBN4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispfatcakekkbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPFATCAHANKEIIKBN4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispfatcahankeiikbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPBIKKNZSYNO4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispbikknzsyno4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPSYOMEIYMD4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispsyomeiymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPFATCATGKBN4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispfatcatgkbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPNMKN4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispnmkn4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPNMKJ4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispnmkj4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPSEIYMD4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispseiymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPSEI4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispsei4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO4_VTDKTDISPKOURYOKUENDYMD4 = new Item("khdshr", "dispFatcaInfo4", "vtdktdispkouryokuendymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPSYORIYMD5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispsyoriymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPFATCASNSIKBN5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispfatcasnsikbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPBIKKJNSSINFOKBN5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispbikkjnssinfokbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPFATCAKEKKBN5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispfatcakekkbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPFATCAHANKEIIKBN5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispfatcahankeiikbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPBIKKNZSYNO5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispbikknzsyno5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPSYOMEIYMD5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispsyomeiymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPFATCATGKBN5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispfatcatgkbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPNMKN5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispnmkn5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPNMKJ5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispnmkj5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPSEIYMD5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispseiymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPSEI5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispsei5", null, ErrorMsgKbn.DD);

    static final Item DDID_DISPFATCAINFO5_VTDKTDISPKOURYOKUENDYMD5 = new Item("khdshr", "dispFatcaInfo5", "vtdktdispkouryokuendymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_KEIYAKUSYAINFO_VKYKSKYKNMKN = new Item("khdshr", "keiyakusyaInfo", "vkykskyknmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUSYAINFO_VKYKSKYKNMKJ = new Item("khdshr", "keiyakusyaInfo", "vkykskyknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUSYAINFO_VKYKSKYKNMKJKHUKAKBN = new Item("khdshr", "keiyakusyaInfo", "vkykskyknmkjkhukakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEIYAKUSYAINFO_VKYKSKYKSEIYMD = new Item("khdshr", "keiyakusyaInfo", "vkykskykseiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUSYAINFO_VKYKSKYKSEI = new Item("khdshr", "keiyakusyaInfo", "vkykskyksei", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUSYAINFO_VKYKSKKKYKTDK = new Item("khdshr", "keiyakusyaInfo", "vkykskkkyktdk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HJNDAIYINFO_VKYKSHJNDAIYKKBN = new Item("khdshr", "hjndaiyInfo", "vkykshjndaiykkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HJNDAIYINFO_VKYKSHJNDAIYKNM = new Item("khdshr", "hjndaiyInfo", "vkykshjndaiyknm", null, ErrorMsgKbn.DD);

    static final Item DDID_HJNDAIYINFO_VKYKSHJNDAINMKN = new Item("khdshr", "hjndaiyInfo", "vkykshjndainmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HJNDAIYINFO_VKYKSHJNDAINMKJ = new Item("khdshr", "hjndaiyInfo", "vkykshjndainmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_TUUSINSAKIINFO_VTSSKTSINYNO = new Item("khdshr", "tuusinsakiInfo", "vtssktsinyno", null, ErrorMsgKbn.DD);

    static final Item DDID_TUUSINSAKIINFO_VTSSKTSINADR1KJ = new Item("khdshr", "tuusinsakiInfo", "vtssktsinadr1kj", null, ErrorMsgKbn.DD);

    static final Item DDID_TUUSINSAKIINFO_VTSSKTSINADR2KJ = new Item("khdshr", "tuusinsakiInfo", "vtssktsinadr2kj", null, ErrorMsgKbn.DD);

    static final Item DDID_TUUSINSAKIINFO_VTSSKTSINADR3KJ = new Item("khdshr", "tuusinsakiInfo", "vtssktsinadr3kj", null, ErrorMsgKbn.DD);

    static final Item DDID_TUUSINSAKIINFO_VTSSKTSINTELNO = new Item("khdshr", "tuusinsakiInfo", "vtssktsintelno", null, ErrorMsgKbn.DD);

    static final Item DDID_TUUSINSAKIINFO_VTSSKDAI2TSINTELNO = new Item("khdshr", "tuusinsakiInfo", "vtsskdai2tsintelno", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUSYOUHNNM = new Item("khdshr", "hosyouInfo", "vhsyusyusyouhnnm", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUAISYOUMEIKBN = new Item("khdshr", "hosyouInfo", "vhsyuaisyoumeikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKYKTUUKASYU = new Item("khdshr", "hosyouInfo", "vhsyusyukyktuukasyu", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKYKJISITEITUUKASYU = new Item("khdshr", "hosyouInfo", "vhsyusyukykjisiteituukasyu", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKATAKBN = new Item("khdshr", "hosyouInfo", "vhsyusyukatakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKYHGNDKATAKBN = new Item("khdshr", "hosyouInfo", "vhsyusyukyhgndkatakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHHKNNEN = new Item("khdshr", "hosyouInfo", "vhsyusyuhhknnen", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKYKYMD = new Item("khdshr", "hosyouInfo", "vhsyusyukykymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUSKNNKAISIYMD = new Item("khdshr", "hosyouInfo", "vhsyusyusknnkaisiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUGANSKNNKAISIYMD = new Item("khdshr", "hosyouInfo", "vhsyugansknnkaisiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUFKTSKNNKAISIYMD = new Item("khdshr", "hosyouInfo", "vhsyusyufktsknnkaisiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUHKGOGANSKNNKAISIYMD = new Item("khdshr", "hosyouInfo", "vhsyuhkgogansknnkaisiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUYENDTHNKYMD = new Item("khdshr", "hosyouInfo", "vhsyuyendthnkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUTMTTKNITENYMD = new Item("khdshr", "hosyouInfo", "vhsyutmttknitenymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHKNKKN = new Item("khdshr", "hosyouInfo", "vhsyusyuhknkkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHKNKKNSMNKBN = new Item("khdshr", "hosyouInfo", "vhsyusyuhknkknsmnkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHRKKKN = new Item("khdshr", "hosyouInfo", "vhsyusyuhrkkkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHRKKKNSMNKBN = new Item("khdshr", "hosyouInfo", "vhsyusyuhrkkknsmnkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUDAI1HKNKKN = new Item("khdshr", "hosyouInfo", "vhsyudai1hknkkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSDPDKBN = new Item("khdshr", "hosyouInfo", "vhsyusdpdkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKIHONSSYURUIKBN = new Item("khdshr", "hosyouInfo", "vhsyusyukihonssyuruikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKIHONS = new Item("khdshr", "hosyouInfo", "vhsyusyukihons", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUDISPSYUTSNSHRGNDGK = new Item("khdshr", "hosyouInfo", "vhsyudispsyutsnshrgndgk", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUP = new Item("khdshr", "hosyouInfo", "vhsyusyup", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKYKKJNKNGK = new Item("khdshr", "hosyouInfo", "vhsyusyukykkjnkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUGENZAISBHKNKNGAKU = new Item("khdshr", "hosyouInfo", "vhsyugenzaisbhknkngaku", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSAIGAISBHKNKNGAKU = new Item("khdshr", "hosyouInfo", "vhsyusaigaisbhknkngaku", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKIHONKYHGK = new Item("khdshr", "hosyouInfo", "vhsyusyukihonkyhgk", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUNEXTKOSGOP = new Item("khdshr", "hosyouInfo", "vhsyusyunextkosgop", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSYUSYUKYHKINKATAKBN = new Item("khdshr", "hosyouInfo", "vhsyusyusyukyhkinkatakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUROKUDAILDKBN = new Item("khdshr", "hosyouInfo", "vhsyusyurokudaildkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSYUGANNYUKYHNTGK = new Item("khdshr", "hosyouInfo", "vhsyusyugannyukyhntgk", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUSHRSKGNSTARTYMD = new Item("khdshr", "hosyouInfo", "vhsyusyushrskgnstartymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUSHRSKGNENDYMD = new Item("khdshr", "hosyouInfo", "vhsyusyushrskgnendymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUSHRSKGNGOS = new Item("khdshr", "hosyouInfo", "vhsyusyushrskgngos", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUNKSHRSTARTYMD = new Item("khdshr", "hosyouInfo", "vhsyusyunkshrstartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSYUNNKINSYUKBN = new Item("khdshr", "hosyouInfo", "vhsyusyunnkinsyukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUNENKINKKN = new Item("khdshr", "hosyouInfo", "vhsyusyunenkinkkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUGENZAITMTTKNGK = new Item("khdshr", "hosyouInfo", "vhsyugenzaitmttkngk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUTEIRITUTMTTKNGK = new Item("khdshr", "hosyouInfo", "vhsyuteiritutmttkngk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUTEIRITUTMTTRATE = new Item("khdshr", "hosyouInfo", "vhsyuteiritutmttrate", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSISUURENDOUTMTTKNGK = new Item("khdshr", "hosyouInfo", "vhsyusisuurendoutmttkngk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSISUURENDOURATE = new Item("khdshr", "hosyouInfo", "vhsyusisuurendourate", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSISUUNM = new Item("khdshr", "hosyouInfo", "vhsyusisuunm", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSETTEIBAIRITU = new Item("khdshr", "hosyouInfo", "vhsyusetteibairitu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUYOTEIRIRITU = new Item("khdshr", "hosyouInfo", "vhsyuyoteiriritu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUTUMITATERIRITU = new Item("khdshr", "hosyouInfo", "vhsyutumitateriritu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUKYKTUMITATERIRITU = new Item("khdshr", "hosyouInfo", "vhsyukyktumitateriritu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYU10NENTUMITATERIRITU = new Item("khdshr", "hosyouInfo", "vhsyu10nentumitateriritu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUKYKSJKKKTYOUSEIRIRITU = new Item("khdshr", "hosyouInfo", "vhsyukyksjkkktyouseiriritu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSKISJKKKTYOUSEIRIRITU = new Item("khdshr", "hosyouInfo", "vhsyuskisjkkktyouseiriritu", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNKKN = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnkkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDSYMD1 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndsymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDEYMD1 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndeymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNS1 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgns1", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDSYMD2 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndsymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDEYMD2 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndeymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNS2 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgns2", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDSYMD3 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndsymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDEYMD3 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndeymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNS3 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgns3", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDSYMD4 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndsymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDEYMD4 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndeymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNS4 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgns4", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDSYMD5 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndsymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNHKNDEYMD5 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgnhkndeymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYSKGNS5 = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyskgns5", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYHYOUTEN = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyhyouten", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTKJYP = new Item("khdshr", "hosyouInfo", "vhsyusyutkjyp", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUICD1 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuicd1", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUINM1 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuinm1", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPKKN1 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpkkn1", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUICD2 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuicd2", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUINM2 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuinm2", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPKKN2 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpkkn2", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUICD3 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuicd3", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUINM3 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuinm3", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPKKN3 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpkkn3", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUICD4 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuicd4", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPBUINM4 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpbuinm4", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUHTNPKKN4 = new Item("khdshr", "hosyouInfo", "vhsyusyuhtnpkkn4", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTOKKDSGHTNPKBN = new Item("khdshr", "hosyouInfo", "vhsyusyutokkdsghtnpkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUTUTAKNGK = new Item("khdshr", "hosyouInfo", "vhsyusyututakngk", null, ErrorMsgKbn.DD);

    static final Item DDID_HOSYOUINFO_VHSYUSYUKOURYOKUHASSEIYMD = new Item("khdshr", "hosyouInfo", "vhsyusyukouryokuhasseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_TBKTINFO_VHSYUDISPFUNDUNITKBNVAL = new Item("khdshr", "tbktInfo", "vhsyudispfundunitkbnval", null, ErrorMsgKbn.DD);

    static final Item DDID_TBKTINFO_VHSYUDISPFUNDUNITKBN = new Item("khdshr", "tbktInfo", "vhsyudispfundunitkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_TBKTINFO_VHSYUDISPUNITSUU = new Item("khdshr", "tbktInfo", "vhsyudispunitsuu", null, ErrorMsgKbn.DD);

    static final Item DDID_TBKTINFO_VHSYUDISPFUNDINDEX = new Item("khdshr", "tbktInfo", "vhsyudispfundindex", null, ErrorMsgKbn.DD);

    static final Item DDID_TBKTINFO_VHSYUDISPTUTAKNGK = new Item("khdshr", "tbktInfo", "vhsyudisptutakngk", null, ErrorMsgKbn.DD);

    static final Item DDID_TBKTINFO_VHSYUDISPWARIAI = new Item("khdshr", "tbktInfo", "vhsyudispwariai", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO_VHSYUDISPTKSYOUHNNM = new Item("khdshr", "tkInfo", "vhsyudisptksyouhnnm", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO_VHSYUNKSHRTKYKNKSYUKBN = new Item("khdshr", "tkInfo", "vhsyunkshrtkyknksyukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO_VHSYUNKSHRTKYKNKSYUKKN = new Item("khdshr", "tkInfo", "vhsyunkshrtkyknksyukkn", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKSYOUHNNM1 = new Item("khdshr", "tkInfo1", "vhsyudisptksyouhnnm1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKKTUUKASYU1 = new Item("khdshr", "tkInfo1", "vhsyudisptkktuukasyu1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTOKYAKUKATAKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptokyakukatakbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKKYHGDKATAKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptkkyhgdkatakbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHHKNNEN1 = new Item("khdshr", "tkInfo1", "vhsyudisptkhhknnen1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKKYKYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptkkykymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKSKNNKAISIYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptksknnkaisiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKGASKKAISIYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptkgaskkaisiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHKSKKAISIYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptkhkskkaisiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHKGSKKSIYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptkhkgskksiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHKNKKN1 = new Item("khdshr", "tkInfo1", "vhsyudisptkhknkkn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHKNKKNSMNKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptkhknkknsmnkbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHRKKKN1 = new Item("khdshr", "tkInfo1", "vhsyudisptkhrkkkn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHRKKKNSMNKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptkhrkkknsmnkbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKKIHSYURUIKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptkkihsyuruikbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKKIHONS1 = new Item("khdshr", "tkInfo1", "vhsyudisptkkihons1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTSNSHRGNDGK1 = new Item("khdshr", "tkInfo1", "vhsyudisptktsnshrgndgk1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKP1 = new Item("khdshr", "tkInfo1", "vhsyudisptkp1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKKIHONKYHGK1 = new Item("khdshr", "tkInfo1", "vhsyudisptkkihonkyhgk1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKNEXTKOSGOP1 = new Item("khdshr", "tkInfo1", "vhsyudisptknextkosgop1", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO1_VHSYUDISPTKSYKYHKATAKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptksykyhkatakbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTK6DAILDKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptk6daildkbn1", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO1_VHSYUDISPTKGANYUKYHNTGK1 = new Item("khdshr", "tkInfo1", "vhsyudisptkganyukyhntgk1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKSHRSKGSTRYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptkshrskgstrymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKSHRSKGNEDYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptkshrskgnedymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKSHRSKGNGOS1 = new Item("khdshr", "tkInfo1", "vhsyudisptkshrskgngos1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKNENKINSYUKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptknenkinsyukbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKNENKINKKN1 = new Item("khdshr", "tkInfo1", "vhsyudisptknenkinkkn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYSKGNKKN1 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyskgnkkn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDSYMD11 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdsymd11", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDEYMD11 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdeymd11", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYSKGNS11 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyskgns11", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDSYMD21 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdsymd21", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDEYMD21 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdeymd21", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYSKGNS21 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyskgns21", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDSYMD31 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdsymd31", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDEYMD31 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdeymd31", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYSKGNS31 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyskgns31", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDSYMD41 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdsymd41", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDEYMD41 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdeymd41", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYSKGNS41 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyskgns41", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDSYMD51 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdsymd51", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJKHKDEYMD51 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjkhkdeymd51", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYSKGNS51 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyskgns51", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYHYOUTEN1 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyhyouten1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKJYP1 = new Item("khdshr", "tkInfo1", "vhsyudisptktkjyp1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUICD11 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuicd11", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUINM11 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuinm11", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPKKN11 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpkkn11", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUICD21 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuicd21", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUINM21 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuinm21", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPKKN21 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpkkn21", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUICD31 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuicd31", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUINM31 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuinm31", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPKKN31 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpkkn31", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUICD41 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuicd41", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPBUINM41 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpbuinm41", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKHTNPKKN41 = new Item("khdshr", "tkInfo1", "vhsyudisptkhtnpkkn41", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTKKDSGHTPKBN1 = new Item("khdshr", "tkInfo1", "vhsyudisptktkkdsghtpkbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKTUTAKNGK1 = new Item("khdshr", "tkInfo1", "vhsyudisptktutakngk1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO1_VHSYUDISPTKKRKHASSEIYMD1 = new Item("khdshr", "tkInfo1", "vhsyudisptkkrkhasseiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKSYOUHNNM2 = new Item("khdshr", "tkInfo2", "vhsyudisptksyouhnnm2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKKTUUKASYU2 = new Item("khdshr", "tkInfo2", "vhsyudisptkktuukasyu2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTOKYAKUKATAKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptokyakukatakbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKKYHGDKATAKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptkkyhgdkatakbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHHKNNEN2 = new Item("khdshr", "tkInfo2", "vhsyudisptkhhknnen2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKKYKYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptkkykymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKSKNNKAISIYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptksknnkaisiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKGASKKAISIYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptkgaskkaisiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHKSKKAISIYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptkhkskkaisiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHKGSKKSIYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptkhkgskksiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHKNKKN2 = new Item("khdshr", "tkInfo2", "vhsyudisptkhknkkn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHKNKKNSMNKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptkhknkknsmnkbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHRKKKN2 = new Item("khdshr", "tkInfo2", "vhsyudisptkhrkkkn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHRKKKNSMNKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptkhrkkknsmnkbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKKIHSYURUIKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptkkihsyuruikbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKKIHONS2 = new Item("khdshr", "tkInfo2", "vhsyudisptkkihons2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTSNSHRGNDGK2 = new Item("khdshr", "tkInfo2", "vhsyudisptktsnshrgndgk2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKP2 = new Item("khdshr", "tkInfo2", "vhsyudisptkp2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKKIHONKYHGK2 = new Item("khdshr", "tkInfo2", "vhsyudisptkkihonkyhgk2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKNEXTKOSGOP2 = new Item("khdshr", "tkInfo2", "vhsyudisptknextkosgop2", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO2_VHSYUDISPTKSYKYHKATAKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptksykyhkatakbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTK6DAILDKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptk6daildkbn2", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO2_VHSYUDISPTKGANYUKYHNTGK2 = new Item("khdshr", "tkInfo2", "vhsyudisptkganyukyhntgk2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKSHRSKGSTRYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptkshrskgstrymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKSHRSKGNEDYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptkshrskgnedymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKSHRSKGNGOS2 = new Item("khdshr", "tkInfo2", "vhsyudisptkshrskgngos2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKNENKINSYUKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptknenkinsyukbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKNENKINKKN2 = new Item("khdshr", "tkInfo2", "vhsyudisptknenkinkkn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYSKGNKKN2 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyskgnkkn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDSYMD12 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdsymd12", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDEYMD12 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdeymd12", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYSKGNS12 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyskgns12", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDSYMD22 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdsymd22", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDEYMD22 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdeymd22", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYSKGNS22 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyskgns22", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDSYMD32 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdsymd32", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDEYMD32 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdeymd32", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYSKGNS32 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyskgns32", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDSYMD42 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdsymd42", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDEYMD42 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdeymd42", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYSKGNS42 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyskgns42", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDSYMD52 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdsymd52", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJKHKDEYMD52 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjkhkdeymd52", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYSKGNS52 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyskgns52", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYHYOUTEN2 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyhyouten2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKJYP2 = new Item("khdshr", "tkInfo2", "vhsyudisptktkjyp2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUICD12 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuicd12", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUINM12 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuinm12", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPKKN12 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpkkn12", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUICD22 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuicd22", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUINM22 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuinm22", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPKKN22 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpkkn22", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUICD32 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuicd32", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUINM32 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuinm32", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPKKN32 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpkkn32", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUICD42 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuicd42", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPBUINM42 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpbuinm42", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKHTNPKKN42 = new Item("khdshr", "tkInfo2", "vhsyudisptkhtnpkkn42", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTKKDSGHTPKBN2 = new Item("khdshr", "tkInfo2", "vhsyudisptktkkdsghtpkbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKTUTAKNGK2 = new Item("khdshr", "tkInfo2", "vhsyudisptktutakngk2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO2_VHSYUDISPTKKRKHASSEIYMD2 = new Item("khdshr", "tkInfo2", "vhsyudisptkkrkhasseiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKSYOUHNNM3 = new Item("khdshr", "tkInfo3", "vhsyudisptksyouhnnm3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKKTUUKASYU3 = new Item("khdshr", "tkInfo3", "vhsyudisptkktuukasyu3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTOKYAKUKATAKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptokyakukatakbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKKYHGDKATAKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptkkyhgdkatakbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHHKNNEN3 = new Item("khdshr", "tkInfo3", "vhsyudisptkhhknnen3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKKYKYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptkkykymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKSKNNKAISIYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptksknnkaisiymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKGASKKAISIYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptkgaskkaisiymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHKSKKAISIYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptkhkskkaisiymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHKGSKKSIYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptkhkgskksiymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHKNKKN3 = new Item("khdshr", "tkInfo3", "vhsyudisptkhknkkn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHKNKKNSMNKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptkhknkknsmnkbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHRKKKN3 = new Item("khdshr", "tkInfo3", "vhsyudisptkhrkkkn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHRKKKNSMNKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptkhrkkknsmnkbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKKIHSYURUIKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptkkihsyuruikbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKKIHONS3 = new Item("khdshr", "tkInfo3", "vhsyudisptkkihons3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTSNSHRGNDGK3 = new Item("khdshr", "tkInfo3", "vhsyudisptktsnshrgndgk3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKP3 = new Item("khdshr", "tkInfo3", "vhsyudisptkp3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKKIHONKYHGK3 = new Item("khdshr", "tkInfo3", "vhsyudisptkkihonkyhgk3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKNEXTKOSGOP3 = new Item("khdshr", "tkInfo3", "vhsyudisptknextkosgop3", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO3_VHSYUDISPTKSYKYHKATAKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptksykyhkatakbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTK6DAILDKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptk6daildkbn3", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO3_VHSYUDISPTKGANYUKYHNTGK3 = new Item("khdshr", "tkInfo3", "vhsyudisptkganyukyhntgk3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKSHRSKGSTRYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptkshrskgstrymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKSHRSKGNEDYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptkshrskgnedymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKSHRSKGNGOS3 = new Item("khdshr", "tkInfo3", "vhsyudisptkshrskgngos3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKNENKINSYUKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptknenkinsyukbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKNENKINKKN3 = new Item("khdshr", "tkInfo3", "vhsyudisptknenkinkkn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYSKGNKKN3 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyskgnkkn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDSYMD13 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdsymd13", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDEYMD13 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdeymd13", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYSKGNS13 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyskgns13", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDSYMD23 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdsymd23", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDEYMD23 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdeymd23", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYSKGNS23 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyskgns23", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDSYMD33 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdsymd33", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDEYMD33 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdeymd33", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYSKGNS33 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyskgns33", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDSYMD43 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdsymd43", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDEYMD43 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdeymd43", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYSKGNS43 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyskgns43", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDSYMD53 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdsymd53", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJKHKDEYMD53 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjkhkdeymd53", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYSKGNS53 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyskgns53", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYHYOUTEN3 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyhyouten3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKJYP3 = new Item("khdshr", "tkInfo3", "vhsyudisptktkjyp3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUICD13 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuicd13", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUINM13 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuinm13", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPKKN13 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpkkn13", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUICD23 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuicd23", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUINM23 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuinm23", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPKKN23 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpkkn23", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUICD33 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuicd33", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUINM33 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuinm33", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPKKN33 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpkkn33", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUICD43 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuicd43", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPBUINM43 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpbuinm43", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKHTNPKKN43 = new Item("khdshr", "tkInfo3", "vhsyudisptkhtnpkkn43", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTKKDSGHTPKBN3 = new Item("khdshr", "tkInfo3", "vhsyudisptktkkdsghtpkbn3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKTUTAKNGK3 = new Item("khdshr", "tkInfo3", "vhsyudisptktutakngk3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO3_VHSYUDISPTKKRKHASSEIYMD3 = new Item("khdshr", "tkInfo3", "vhsyudisptkkrkhasseiymd3", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKSYOUHNNM4 = new Item("khdshr", "tkInfo4", "vhsyudisptksyouhnnm4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKKTUUKASYU4 = new Item("khdshr", "tkInfo4", "vhsyudisptkktuukasyu4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTOKYAKUKATAKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptokyakukatakbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKKYHGDKATAKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptkkyhgdkatakbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHHKNNEN4 = new Item("khdshr", "tkInfo4", "vhsyudisptkhhknnen4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKKYKYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptkkykymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKSKNNKAISIYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptksknnkaisiymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKGASKKAISIYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptkgaskkaisiymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHKSKKAISIYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptkhkskkaisiymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHKGSKKSIYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptkhkgskksiymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHKNKKN4 = new Item("khdshr", "tkInfo4", "vhsyudisptkhknkkn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHKNKKNSMNKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptkhknkknsmnkbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHRKKKN4 = new Item("khdshr", "tkInfo4", "vhsyudisptkhrkkkn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHRKKKNSMNKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptkhrkkknsmnkbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKKIHSYURUIKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptkkihsyuruikbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKKIHONS4 = new Item("khdshr", "tkInfo4", "vhsyudisptkkihons4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTSNSHRGNDGK4 = new Item("khdshr", "tkInfo4", "vhsyudisptktsnshrgndgk4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKP4 = new Item("khdshr", "tkInfo4", "vhsyudisptkp4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKKIHONKYHGK4 = new Item("khdshr", "tkInfo4", "vhsyudisptkkihonkyhgk4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKNEXTKOSGOP4 = new Item("khdshr", "tkInfo4", "vhsyudisptknextkosgop4", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO4_VHSYUDISPTKSYKYHKATAKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptksykyhkatakbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTK6DAILDKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptk6daildkbn4", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO4_VHSYUDISPTKGANYUKYHNTGK4 = new Item("khdshr", "tkInfo4", "vhsyudisptkganyukyhntgk4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKSHRSKGSTRYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptkshrskgstrymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKSHRSKGNEDYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptkshrskgnedymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKSHRSKGNGOS4 = new Item("khdshr", "tkInfo4", "vhsyudisptkshrskgngos4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKNENKINSYUKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptknenkinsyukbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKNENKINKKN4 = new Item("khdshr", "tkInfo4", "vhsyudisptknenkinkkn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYSKGNKKN4 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyskgnkkn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDSYMD14 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdsymd14", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDEYMD14 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdeymd14", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYSKGNS14 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyskgns14", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDSYMD24 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdsymd24", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDEYMD24 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdeymd24", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYSKGNS24 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyskgns24", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDSYMD34 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdsymd34", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDEYMD34 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdeymd34", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYSKGNS34 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyskgns34", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDSYMD44 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdsymd44", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDEYMD44 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdeymd44", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYSKGNS44 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyskgns44", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDSYMD54 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdsymd54", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJKHKDEYMD54 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjkhkdeymd54", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYSKGNS54 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyskgns54", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYHYOUTEN4 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyhyouten4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKJYP4 = new Item("khdshr", "tkInfo4", "vhsyudisptktkjyp4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUICD14 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuicd14", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUINM14 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuinm14", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPKKN14 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpkkn14", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUICD24 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuicd24", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUINM24 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuinm24", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPKKN24 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpkkn24", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUICD34 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuicd34", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUINM34 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuinm34", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPKKN34 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpkkn34", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUICD44 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuicd44", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPBUINM44 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpbuinm44", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKHTNPKKN44 = new Item("khdshr", "tkInfo4", "vhsyudisptkhtnpkkn44", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTKKDSGHTPKBN4 = new Item("khdshr", "tkInfo4", "vhsyudisptktkkdsghtpkbn4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKTUTAKNGK4 = new Item("khdshr", "tkInfo4", "vhsyudisptktutakngk4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO4_VHSYUDISPTKKRKHASSEIYMD4 = new Item("khdshr", "tkInfo4", "vhsyudisptkkrkhasseiymd4", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKSYOUHNNM5 = new Item("khdshr", "tkInfo5", "vhsyudisptksyouhnnm5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKKTUUKASYU5 = new Item("khdshr", "tkInfo5", "vhsyudisptkktuukasyu5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTOKYAKUKATAKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptokyakukatakbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKKYHGDKATAKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptkkyhgdkatakbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHHKNNEN5 = new Item("khdshr", "tkInfo5", "vhsyudisptkhhknnen5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKKYKYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptkkykymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKSKNNKAISIYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptksknnkaisiymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKGASKKAISIYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptkgaskkaisiymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHKSKKAISIYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptkhkskkaisiymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHKGSKKSIYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptkhkgskksiymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHKNKKN5 = new Item("khdshr", "tkInfo5", "vhsyudisptkhknkkn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHKNKKNSMNKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptkhknkknsmnkbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHRKKKN5 = new Item("khdshr", "tkInfo5", "vhsyudisptkhrkkkn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHRKKKNSMNKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptkhrkkknsmnkbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKKIHSYURUIKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptkkihsyuruikbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKKIHONS5 = new Item("khdshr", "tkInfo5", "vhsyudisptkkihons5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTSNSHRGNDGK5 = new Item("khdshr", "tkInfo5", "vhsyudisptktsnshrgndgk5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKP5 = new Item("khdshr", "tkInfo5", "vhsyudisptkp5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKKIHONKYHGK5 = new Item("khdshr", "tkInfo5", "vhsyudisptkkihonkyhgk5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKNEXTKOSGOP5 = new Item("khdshr", "tkInfo5", "vhsyudisptknextkosgop5", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO5_VHSYUDISPTKSYKYHKATAKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptksykyhkatakbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTK6DAILDKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptk6daildkbn5", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO5_VHSYUDISPTKGANYUKYHNTGK5 = new Item("khdshr", "tkInfo5", "vhsyudisptkganyukyhntgk5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKSHRSKGSTRYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptkshrskgstrymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKSHRSKGNEDYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptkshrskgnedymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKSHRSKGNGOS5 = new Item("khdshr", "tkInfo5", "vhsyudisptkshrskgngos5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKNENKINSYUKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptknenkinsyukbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKNENKINKKN5 = new Item("khdshr", "tkInfo5", "vhsyudisptknenkinkkn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYSKGNKKN5 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyskgnkkn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDSYMD15 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdsymd15", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDEYMD15 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdeymd15", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYSKGNS15 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyskgns15", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDSYMD25 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdsymd25", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDEYMD25 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdeymd25", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYSKGNS25 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyskgns25", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDSYMD35 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdsymd35", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDEYMD35 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdeymd35", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYSKGNS35 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyskgns35", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDSYMD45 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdsymd45", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDEYMD45 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdeymd45", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYSKGNS45 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyskgns45", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDSYMD55 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdsymd55", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJKHKDEYMD55 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjkhkdeymd55", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYSKGNS55 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyskgns55", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYHYOUTEN5 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyhyouten5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKJYP5 = new Item("khdshr", "tkInfo5", "vhsyudisptktkjyp5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUICD15 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuicd15", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUINM15 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuinm15", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPKKN15 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpkkn15", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUICD25 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuicd25", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUINM25 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuinm25", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPKKN25 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpkkn25", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUICD35 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuicd35", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUINM35 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuinm35", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPKKN35 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpkkn35", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUICD45 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuicd45", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPBUINM45 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpbuinm45", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKHTNPKKN45 = new Item("khdshr", "tkInfo5", "vhsyudisptkhtnpkkn45", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTKKDSGHTPKBN5 = new Item("khdshr", "tkInfo5", "vhsyudisptktkkdsghtpkbn5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKTUTAKNGK5 = new Item("khdshr", "tkInfo5", "vhsyudisptktutakngk5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO5_VHSYUDISPTKKRKHASSEIYMD5 = new Item("khdshr", "tkInfo5", "vhsyudisptkkrkhasseiymd5", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKSYOUHNNM6 = new Item("khdshr", "tkInfo6", "vhsyudisptksyouhnnm6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKKTUUKASYU6 = new Item("khdshr", "tkInfo6", "vhsyudisptkktuukasyu6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTOKYAKUKATAKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptokyakukatakbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKKYHGDKATAKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptkkyhgdkatakbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHHKNNEN6 = new Item("khdshr", "tkInfo6", "vhsyudisptkhhknnen6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKKYKYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptkkykymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKSKNNKAISIYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptksknnkaisiymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKGASKKAISIYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptkgaskkaisiymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHKSKKAISIYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptkhkskkaisiymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHKGSKKSIYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptkhkgskksiymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHKNKKN6 = new Item("khdshr", "tkInfo6", "vhsyudisptkhknkkn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHKNKKNSMNKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptkhknkknsmnkbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHRKKKN6 = new Item("khdshr", "tkInfo6", "vhsyudisptkhrkkkn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHRKKKNSMNKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptkhrkkknsmnkbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKKIHSYURUIKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptkkihsyuruikbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKKIHONS6 = new Item("khdshr", "tkInfo6", "vhsyudisptkkihons6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTSNSHRGNDGK6 = new Item("khdshr", "tkInfo6", "vhsyudisptktsnshrgndgk6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKP6 = new Item("khdshr", "tkInfo6", "vhsyudisptkp6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKKIHONKYHGK6 = new Item("khdshr", "tkInfo6", "vhsyudisptkkihonkyhgk6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKNEXTKOSGOP6 = new Item("khdshr", "tkInfo6", "vhsyudisptknextkosgop6", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO6_VHSYUDISPTKSYKYHKATAKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptksykyhkatakbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTK6DAILDKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptk6daildkbn6", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO6_VHSYUDISPTKGANYUKYHNTGK6 = new Item("khdshr", "tkInfo6", "vhsyudisptkganyukyhntgk6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKSHRSKGSTRYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptkshrskgstrymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKSHRSKGNEDYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptkshrskgnedymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKSHRSKGNGOS6 = new Item("khdshr", "tkInfo6", "vhsyudisptkshrskgngos6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKNENKINSYUKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptknenkinsyukbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKNENKINKKN6 = new Item("khdshr", "tkInfo6", "vhsyudisptknenkinkkn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYSKGNKKN6 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyskgnkkn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDSYMD16 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdsymd16", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDEYMD16 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdeymd16", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYSKGNS16 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyskgns16", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDSYMD26 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdsymd26", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDEYMD26 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdeymd26", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYSKGNS26 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyskgns26", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDSYMD36 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdsymd36", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDEYMD36 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdeymd36", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYSKGNS36 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyskgns36", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDSYMD46 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdsymd46", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDEYMD46 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdeymd46", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYSKGNS46 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyskgns46", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDSYMD56 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdsymd56", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJKHKDEYMD56 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjkhkdeymd56", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYSKGNS56 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyskgns56", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYHYOUTEN6 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyhyouten6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKJYP6 = new Item("khdshr", "tkInfo6", "vhsyudisptktkjyp6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUICD16 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuicd16", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUINM16 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuinm16", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPKKN16 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpkkn16", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUICD26 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuicd26", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUINM26 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuinm26", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPKKN26 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpkkn26", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUICD36 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuicd36", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUINM36 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuinm36", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPKKN36 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpkkn36", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUICD46 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuicd46", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPBUINM46 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpbuinm46", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKHTNPKKN46 = new Item("khdshr", "tkInfo6", "vhsyudisptkhtnpkkn46", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTKKDSGHTPKBN6 = new Item("khdshr", "tkInfo6", "vhsyudisptktkkdsghtpkbn6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKTUTAKNGK6 = new Item("khdshr", "tkInfo6", "vhsyudisptktutakngk6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO6_VHSYUDISPTKKRKHASSEIYMD6 = new Item("khdshr", "tkInfo6", "vhsyudisptkkrkhasseiymd6", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKSYOUHNNM7 = new Item("khdshr", "tkInfo7", "vhsyudisptksyouhnnm7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKKTUUKASYU7 = new Item("khdshr", "tkInfo7", "vhsyudisptkktuukasyu7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTOKYAKUKATAKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptokyakukatakbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKKYHGDKATAKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptkkyhgdkatakbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHHKNNEN7 = new Item("khdshr", "tkInfo7", "vhsyudisptkhhknnen7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKKYKYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptkkykymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKSKNNKAISIYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptksknnkaisiymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKGASKKAISIYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptkgaskkaisiymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHKSKKAISIYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptkhkskkaisiymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHKGSKKSIYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptkhkgskksiymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHKNKKN7 = new Item("khdshr", "tkInfo7", "vhsyudisptkhknkkn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHKNKKNSMNKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptkhknkknsmnkbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHRKKKN7 = new Item("khdshr", "tkInfo7", "vhsyudisptkhrkkkn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHRKKKNSMNKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptkhrkkknsmnkbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKKIHSYURUIKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptkkihsyuruikbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKKIHONS7 = new Item("khdshr", "tkInfo7", "vhsyudisptkkihons7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTSNSHRGNDGK7 = new Item("khdshr", "tkInfo7", "vhsyudisptktsnshrgndgk7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKP7 = new Item("khdshr", "tkInfo7", "vhsyudisptkp7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKKIHONKYHGK7 = new Item("khdshr", "tkInfo7", "vhsyudisptkkihonkyhgk7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKNEXTKOSGOP7 = new Item("khdshr", "tkInfo7", "vhsyudisptknextkosgop7", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO7_VHSYUDISPTKSYKYHKATAKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptksykyhkatakbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTK6DAILDKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptk6daildkbn7", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO7_VHSYUDISPTKGANYUKYHNTGK7 = new Item("khdshr", "tkInfo7", "vhsyudisptkganyukyhntgk7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKSHRSKGSTRYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptkshrskgstrymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKSHRSKGNEDYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptkshrskgnedymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKSHRSKGNGOS7 = new Item("khdshr", "tkInfo7", "vhsyudisptkshrskgngos7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKNENKINSYUKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptknenkinsyukbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKNENKINKKN7 = new Item("khdshr", "tkInfo7", "vhsyudisptknenkinkkn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYSKGNKKN7 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyskgnkkn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDSYMD17 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdsymd17", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDEYMD17 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdeymd17", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYSKGNS17 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyskgns17", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDSYMD27 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdsymd27", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDEYMD27 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdeymd27", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYSKGNS27 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyskgns27", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDSYMD37 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdsymd37", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDEYMD37 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdeymd37", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYSKGNS37 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyskgns37", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDSYMD47 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdsymd47", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDEYMD47 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdeymd47", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYSKGNS47 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyskgns47", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDSYMD57 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdsymd57", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJKHKDEYMD57 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjkhkdeymd57", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYSKGNS57 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyskgns57", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYHYOUTEN7 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyhyouten7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKJYP7 = new Item("khdshr", "tkInfo7", "vhsyudisptktkjyp7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUICD17 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuicd17", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUINM17 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuinm17", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPKKN17 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpkkn17", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUICD27 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuicd27", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUINM27 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuinm27", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPKKN27 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpkkn27", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUICD37 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuicd37", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUINM37 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuinm37", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPKKN37 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpkkn37", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUICD47 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuicd47", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPBUINM47 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpbuinm47", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKHTNPKKN47 = new Item("khdshr", "tkInfo7", "vhsyudisptkhtnpkkn47", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTKKDSGHTPKBN7 = new Item("khdshr", "tkInfo7", "vhsyudisptktkkdsghtpkbn7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKTUTAKNGK7 = new Item("khdshr", "tkInfo7", "vhsyudisptktutakngk7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO7_VHSYUDISPTKKRKHASSEIYMD7 = new Item("khdshr", "tkInfo7", "vhsyudisptkkrkhasseiymd7", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKSYOUHNNM8 = new Item("khdshr", "tkInfo8", "vhsyudisptksyouhnnm8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKKTUUKASYU8 = new Item("khdshr", "tkInfo8", "vhsyudisptkktuukasyu8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTOKYAKUKATAKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptokyakukatakbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKKYHGDKATAKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptkkyhgdkatakbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHHKNNEN8 = new Item("khdshr", "tkInfo8", "vhsyudisptkhhknnen8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKKYKYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptkkykymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKSKNNKAISIYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptksknnkaisiymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKGASKKAISIYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptkgaskkaisiymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHKSKKAISIYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptkhkskkaisiymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHKGSKKSIYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptkhkgskksiymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHKNKKN8 = new Item("khdshr", "tkInfo8", "vhsyudisptkhknkkn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHKNKKNSMNKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptkhknkknsmnkbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHRKKKN8 = new Item("khdshr", "tkInfo8", "vhsyudisptkhrkkkn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHRKKKNSMNKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptkhrkkknsmnkbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKKIHSYURUIKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptkkihsyuruikbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKKIHONS8 = new Item("khdshr", "tkInfo8", "vhsyudisptkkihons8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTSNSHRGNDGK8 = new Item("khdshr", "tkInfo8", "vhsyudisptktsnshrgndgk8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKP8 = new Item("khdshr", "tkInfo8", "vhsyudisptkp8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKKIHONKYHGK8 = new Item("khdshr", "tkInfo8", "vhsyudisptkkihonkyhgk8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKNEXTKOSGOP8 = new Item("khdshr", "tkInfo8", "vhsyudisptknextkosgop8", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO8_VHSYUDISPTKSYKYHKATAKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptksykyhkatakbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTK6DAILDKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptk6daildkbn8", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO8_VHSYUDISPTKGANYUKYHNTGK8 = new Item("khdshr", "tkInfo8", "vhsyudisptkganyukyhntgk8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKSHRSKGSTRYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptkshrskgstrymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKSHRSKGNEDYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptkshrskgnedymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKSHRSKGNGOS8 = new Item("khdshr", "tkInfo8", "vhsyudisptkshrskgngos8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKNENKINSYUKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptknenkinsyukbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKNENKINKKN8 = new Item("khdshr", "tkInfo8", "vhsyudisptknenkinkkn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYSKGNKKN8 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyskgnkkn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDSYMD18 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdsymd18", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDEYMD18 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdeymd18", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYSKGNS18 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyskgns18", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDSYMD28 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdsymd28", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDEYMD28 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdeymd28", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYSKGNS28 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyskgns28", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDSYMD38 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdsymd38", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDEYMD38 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdeymd38", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYSKGNS38 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyskgns38", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDSYMD48 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdsymd48", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDEYMD48 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdeymd48", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYSKGNS48 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyskgns48", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDSYMD58 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdsymd58", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJKHKDEYMD58 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjkhkdeymd58", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYSKGNS58 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyskgns58", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYHYOUTEN8 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyhyouten8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKJYP8 = new Item("khdshr", "tkInfo8", "vhsyudisptktkjyp8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUICD18 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuicd18", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUINM18 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuinm18", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPKKN18 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpkkn18", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUICD28 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuicd28", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUINM28 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuinm28", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPKKN28 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpkkn28", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUICD38 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuicd38", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUINM38 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuinm38", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPKKN38 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpkkn38", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUICD48 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuicd48", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPBUINM48 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpbuinm48", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKHTNPKKN48 = new Item("khdshr", "tkInfo8", "vhsyudisptkhtnpkkn48", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTKKDSGHTPKBN8 = new Item("khdshr", "tkInfo8", "vhsyudisptktkkdsghtpkbn8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKTUTAKNGK8 = new Item("khdshr", "tkInfo8", "vhsyudisptktutakngk8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO8_VHSYUDISPTKKRKHASSEIYMD8 = new Item("khdshr", "tkInfo8", "vhsyudisptkkrkhasseiymd8", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKSYOUHNNM9 = new Item("khdshr", "tkInfo9", "vhsyudisptksyouhnnm9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKKTUUKASYU9 = new Item("khdshr", "tkInfo9", "vhsyudisptkktuukasyu9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTOKYAKUKATAKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptokyakukatakbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKKYHGDKATAKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptkkyhgdkatakbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHHKNNEN9 = new Item("khdshr", "tkInfo9", "vhsyudisptkhhknnen9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKKYKYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptkkykymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKSKNNKAISIYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptksknnkaisiymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKGASKKAISIYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptkgaskkaisiymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHKSKKAISIYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptkhkskkaisiymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHKGSKKSIYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptkhkgskksiymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHKNKKN9 = new Item("khdshr", "tkInfo9", "vhsyudisptkhknkkn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHKNKKNSMNKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptkhknkknsmnkbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHRKKKN9 = new Item("khdshr", "tkInfo9", "vhsyudisptkhrkkkn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHRKKKNSMNKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptkhrkkknsmnkbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKKIHSYURUIKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptkkihsyuruikbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKKIHONS9 = new Item("khdshr", "tkInfo9", "vhsyudisptkkihons9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTSNSHRGNDGK9 = new Item("khdshr", "tkInfo9", "vhsyudisptktsnshrgndgk9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKP9 = new Item("khdshr", "tkInfo9", "vhsyudisptkp9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKKIHONKYHGK9 = new Item("khdshr", "tkInfo9", "vhsyudisptkkihonkyhgk9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKNEXTKOSGOP9 = new Item("khdshr", "tkInfo9", "vhsyudisptknextkosgop9", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO9_VHSYUDISPTKSYKYHKATAKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptksykyhkatakbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTK6DAILDKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptk6daildkbn9", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO9_VHSYUDISPTKGANYUKYHNTGK9 = new Item("khdshr", "tkInfo9", "vhsyudisptkganyukyhntgk9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKSHRSKGSTRYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptkshrskgstrymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKSHRSKGNEDYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptkshrskgnedymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKSHRSKGNGOS9 = new Item("khdshr", "tkInfo9", "vhsyudisptkshrskgngos9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKNENKINSYUKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptknenkinsyukbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKNENKINKKN9 = new Item("khdshr", "tkInfo9", "vhsyudisptknenkinkkn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYSKGNKKN9 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyskgnkkn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDSYMD19 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdsymd19", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDEYMD19 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdeymd19", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYSKGNS19 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyskgns19", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDSYMD29 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdsymd29", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDEYMD29 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdeymd29", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYSKGNS29 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyskgns29", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDSYMD39 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdsymd39", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDEYMD39 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdeymd39", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYSKGNS39 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyskgns39", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDSYMD49 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdsymd49", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDEYMD49 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdeymd49", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYSKGNS49 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyskgns49", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDSYMD59 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdsymd59", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJKHKDEYMD59 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjkhkdeymd59", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYSKGNS59 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyskgns59", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYHYOUTEN9 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyhyouten9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKJYP9 = new Item("khdshr", "tkInfo9", "vhsyudisptktkjyp9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUICD19 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuicd19", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUINM19 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuinm19", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPKKN19 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpkkn19", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUICD29 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuicd29", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUINM29 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuinm29", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPKKN29 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpkkn29", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUICD39 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuicd39", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUINM39 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuinm39", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPKKN39 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpkkn39", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUICD49 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuicd49", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPBUINM49 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpbuinm49", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKHTNPKKN49 = new Item("khdshr", "tkInfo9", "vhsyudisptkhtnpkkn49", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTKKDSGHTPKBN9 = new Item("khdshr", "tkInfo9", "vhsyudisptktkkdsghtpkbn9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKTUTAKNGK9 = new Item("khdshr", "tkInfo9", "vhsyudisptktutakngk9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO9_VHSYUDISPTKKRKHASSEIYMD9 = new Item("khdshr", "tkInfo9", "vhsyudisptkkrkhasseiymd9", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKSYOUHNNM10 = new Item("khdshr", "tkInfo10", "vhsyudisptksyouhnnm10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKKTUUKASYU10 = new Item("khdshr", "tkInfo10", "vhsyudisptkktuukasyu10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTOKYAKUKATAKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptokyakukatakbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKKYHGDKATAKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptkkyhgdkatakbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHHKNNEN10 = new Item("khdshr", "tkInfo10", "vhsyudisptkhhknnen10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKKYKYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptkkykymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKSKNNKAISIYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptksknnkaisiymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKGASKKAISIYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptkgaskkaisiymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHKSKKAISIYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptkhkskkaisiymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHKGSKKSIYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptkhkgskksiymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHKNKKN10 = new Item("khdshr", "tkInfo10", "vhsyudisptkhknkkn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHKNKKNSMNKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptkhknkknsmnkbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHRKKKN10 = new Item("khdshr", "tkInfo10", "vhsyudisptkhrkkkn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHRKKKNSMNKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptkhrkkknsmnkbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKKIHSYURUIKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptkkihsyuruikbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKKIHONS10 = new Item("khdshr", "tkInfo10", "vhsyudisptkkihons10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTSNSHRGNDGK10 = new Item("khdshr", "tkInfo10", "vhsyudisptktsnshrgndgk10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKP10 = new Item("khdshr", "tkInfo10", "vhsyudisptkp10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKKIHONKYHGK10 = new Item("khdshr", "tkInfo10", "vhsyudisptkkihonkyhgk10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKNEXTKOSGOP10 = new Item("khdshr", "tkInfo10", "vhsyudisptknextkosgop10", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO10_VHSYUDISPTKSYKYHKATAKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptksykyhkatakbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTK6DAILDKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptk6daildkbn10", null, ErrorMsgKbn.DISP);

    static final Item DDID_TKINFO10_VHSYUDISPTKGANYUKYHNTGK10 = new Item("khdshr", "tkInfo10", "vhsyudisptkganyukyhntgk10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKSHRSKGSTRYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptkshrskgstrymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKSHRSKGNEDYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptkshrskgnedymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKSHRSKGNGOS10 = new Item("khdshr", "tkInfo10", "vhsyudisptkshrskgngos10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKNENKINSYUKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptknenkinsyukbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKNENKINKKN10 = new Item("khdshr", "tkInfo10", "vhsyudisptknenkinkkn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYSKGNKKN10 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyskgnkkn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDSYMD110 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdsymd110", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDEYMD110 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdeymd110", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYSKGNS110 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyskgns110", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDSYMD210 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdsymd210", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDEYMD210 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdeymd210", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYSKGNS210 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyskgns210", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDSYMD310 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdsymd310", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDEYMD310 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdeymd310", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYSKGNS310 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyskgns310", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDSYMD410 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdsymd410", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDEYMD410 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdeymd410", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYSKGNS410 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyskgns410", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDSYMD510 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdsymd510", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJKHKDEYMD510 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjkhkdeymd510", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYSKGNS510 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyskgns510", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYHYOUTEN10 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyhyouten10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKJYP10 = new Item("khdshr", "tkInfo10", "vhsyudisptktkjyp10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUICD110 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuicd110", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUINM110 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuinm110", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPKKN110 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpkkn110", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUICD210 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuicd210", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUINM210 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuinm210", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPKKN210 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpkkn210", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUICD310 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuicd310", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUINM310 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuinm310", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPKKN310 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpkkn310", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUICD410 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuicd410", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPBUINM410 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpbuinm410", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKHTNPKKN410 = new Item("khdshr", "tkInfo10", "vhsyudisptkhtnpkkn410", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTKKDSGHTPKBN10 = new Item("khdshr", "tkInfo10", "vhsyudisptktkkdsghtpkbn10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKTUTAKNGK10 = new Item("khdshr", "tkInfo10", "vhsyudisptktutakngk10", null, ErrorMsgKbn.DD);

    static final Item DDID_TKINFO10_VHSYUDISPTKKRKHASSEIYMD10 = new Item("khdshr", "tkInfo10", "vhsyudisptkkrkhasseiymd10", null, ErrorMsgKbn.DD);

    static final Item DDID_VHSYUHIDDENGROUP_VHSYUITIJIBRUMU = new Item("khdshr", "vhsyuHiddenGroup", "vhsyuitijibrumu", null, ErrorMsgKbn.DD);

    static final Item DDID_VHSYUHIDDENGROUP_VHSYUGENZAIKNGKHYJFUKAUMU = new Item("khdshr", "vhsyuHiddenGroup", "vhsyugenzaikngkhyjfukaumu", null, ErrorMsgKbn.DD);

    static final Item DDID_VHSYUHIDDENGROUP_VHSYUYENDTHNKJYOUTAIKBN = new Item("khdshr", "vhsyuHiddenGroup", "vhsyuyendthnkjyoutaikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_SONOTATKINFO_VSNTKDISPTKHUKAINFO = new Item("khdshr", "sonotaTkInfo", "vsntkdisptkhukainfo", null, ErrorMsgKbn.DISP);

    static final Item DDID_HARAIKOMIINFO_VHRKIFSTPHRKKEIROKBN = new Item("khdshr", "haraikomiInfo", "vhrkifstphrkkeirokbn", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIHRKKAISUU = new Item("khdshr", "haraikomiInfo", "vhrkihrkkaisuu", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIHRKKEIRO = new Item("khdshr", "haraikomiInfo", "vhrkihrkkeiro", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKITIKIKTBRIJK = new Item("khdshr", "haraikomiInfo", "vhrkitikiktbrijk", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIJKIPJYTYM = new Item("khdshr", "haraikomiInfo", "vhrkijkipjytym", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIHRKP = new Item("khdshr", "haraikomiInfo", "vhrkihrkp", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIITIJIBRP = new Item("khdshr", "haraikomiInfo", "vhrkiitijibrp", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIKIHRKP = new Item("khdshr", "haraikomiInfo", "vhrkikihrkp", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKINEXTKOSGOHRKP = new Item("khdshr", "haraikomiInfo", "vhrkinextkosgohrkp", null, ErrorMsgKbn.DISP);

    static final Item DDID_HARAIKOMIINFO_VHRKIYENKANSANNYKNKINGK = new Item("khdshr", "haraikomiInfo", "vhrkiyenkansannyknkingk", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIYENTKYKWSRATEYMD = new Item("khdshr", "haraikomiInfo", "vhrkiyentkykwsrateymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIYENTKYKWSRATE = new Item("khdshr", "haraikomiInfo", "vhrkiyentkykwsrate", null, ErrorMsgKbn.DD);

    static final Item DDID_HARAIKOMIINFO_VHRKIYENTKYKWSRATETUUKASYU = new Item("khdshr", "haraikomiInfo", "vhrkiyentkykwsratetuukasyu", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOBANKCD = new Item("khdshr", "ginkouInfo", "vhrkihrkinfobankcd", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOBANKNMKJ = new Item("khdshr", "ginkouInfo", "vhrkihrkinfobanknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOSITENCD = new Item("khdshr", "ginkouInfo", "vhrkihrkinfositencd", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOSITENNMKJ = new Item("khdshr", "ginkouInfo", "vhrkihrkinfositennmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOTUUTYOUKIGOU = new Item("khdshr", "ginkouInfo", "vhrkihrkinfotuutyoukigou", null, ErrorMsgKbn.DISP);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOYOKINKBN = new Item("khdshr", "ginkouInfo", "vhrkihrkinfoyokinkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOKOUZANO = new Item("khdshr", "ginkouInfo", "vhrkihrkinfokouzano", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOSINKEIZKKBN = new Item("khdshr", "ginkouInfo", "vhrkihrkinfosinkeizkkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIHRKINFOKZMEIGINMKN = new Item("khdshr", "ginkouInfo", "vhrkihrkinfokzmeiginmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_VHRKIKZDOUKBN = new Item("khdshr", "ginkouInfo", "vhrkikzdoukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOCREDITCARDINFO_VHRKIDISPCREDITKESSAIYOUNO = new Item("khdshr", "focreditcardInfo", "vhrkidispcreditkessaiyouno", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOCREDITCARDINFO_VHRKICREDITYUUKOUKAKKEKKA = new Item("khdshr", "focreditcardInfo", "vhrkicredityuukoukakkekka", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOCREDITCARDINFO_VHRKICREDITYUUKOUKAKYM = new Item("khdshr", "focreditcardInfo", "vhrkicredityuukoukakym", null, ErrorMsgKbn.DISP);

    static final Item DDID_ZENNOUINFO_VHRKIZENNOUSTARTYM = new Item("khdshr", "zennouInfo", "vhrkizennoustartym", null, ErrorMsgKbn.DD);

    static final Item DDID_ZENNOUINFO_VHRKIZENNOUKKN = new Item("khdshr", "zennouInfo", "vhrkizennoukkn", null, ErrorMsgKbn.DD);

    static final Item DDID_ZENNOUINFO_VHRKIZENNOUNYUUKINGK = new Item("khdshr", "zennouInfo", "vhrkizennounyuukingk", null, ErrorMsgKbn.DD);

    static final Item DDID_ZENNOUINFO_VHRKIZENNOUNYUUKINYMD = new Item("khdshr", "zennouInfo", "vhrkizennounyuukinymd", null, ErrorMsgKbn.DD);

    static final Item DDID_VHRKIHIDDENGROUP_VHRKIKYKJYOUTAI = new Item("khdshr", "vhrkiHiddenGroup", "vhrkikykjyoutai", null, ErrorMsgKbn.DD);

    static final Item DDID_VHRKIHIDDENGROUP_VHRKIZENKIZENNOUUMU = new Item("khdshr", "vhrkiHiddenGroup", "vhrkizenkizennouumu", null, ErrorMsgKbn.DD);

    static final Item DDID_VHRKIHIDDENGROUP_VHRKICREDITKESSAIYOUNO = new Item("khdshr", "vhrkiHiddenGroup", "vhrkicreditkessaiyouno", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKNMKN1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzknmkn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKNMKJ1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzknmkj1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKNMKJKHUKAKBN1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzknmkjkhukakbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKSEIYMD1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzkseiymd1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKSEI1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzksei1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKTDK1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzktdk1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKYNO1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzkyno1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKADR1KJ1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzkadr1kj1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKADR2KJ1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzkadr2kj1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKADR3KJ1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzkadr3kj1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKTELNO1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzktelno1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO1_VTRKKZKTRKKZKUMUKBN1 = new Item("khdshr", "trkkzkInfo1", "vtrkkzktrkkzkumukbn1", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKNMKN2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzknmkn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKNMKJ2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzknmkj2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKNMKJKHUKAKBN2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzknmkjkhukakbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKSEIYMD2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzkseiymd2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKSEI2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzksei2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKTDK2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzktdk2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKYNO2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzkyno2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKADR1KJ2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzkadr1kj2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKADR2KJ2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzkadr2kj2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKADR3KJ2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzkadr3kj2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKTELNO2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzktelno2", null, ErrorMsgKbn.DD);

    static final Item DDID_TRKKZKINFO2_VTRKKZKTRKKZKUMUKBN2 = new Item("khdshr", "trkkzkInfo2", "vtrkkzktrkkzkumukbn2", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRKBN = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdrkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRNMKN = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdrnmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRNMKJ = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdrnmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRNMKJKHUKAKBN = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdrnmkjkhukakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRSEIYMD = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdrseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRYNO = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdryno", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRADR1KJ = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdradr1kj", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRADR2KJ = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdradr2kj", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKSYADAIRINININFO_VKYKDRKYKDRADR3KJ = new Item("khdshr", "kyksyadairininInfo", "vkykdrkykdradr3kj", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSYORIYMD = new Item("khdshr", "progresshistoryinfo", "vprghsdispsyoriymd", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPTASKNM = new Item("khdshr", "progresshistoryinfo", "vprghsdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSYORIKEKKAKBN = new Item("khdshr", "progresshistoryinfo", "vprghsdispsyorikekkakbn", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPSOUSASYANM = new Item("khdshr", "progresshistoryinfo", "vprghsdispsousasyanm", null, ErrorMsgKbn.DD);

    static final Item DDID_PROGRESSHISTORYINFO_VPRGHSDISPCOMMENT = new Item("khdshr", "progresshistoryinfo", "vprghsdispcomment", null, ErrorMsgKbn.DD);

    static final Item DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD = new Item("khdshr", "shiharaiSyoriNyuuryokuInfo", "syoruiukeymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SHIHARAISYORINYUURYOKUINFO_TUMITATEHAITOUGANRIKIN = new Item("khdshr", "shiharaiSyoriNyuuryokuInfo", "tumitatehaitouganrikin", null, ErrorMsgKbn.DISP);

    static final Item DDID_HITUYOUSYORUIINFO_VHTYSDISPHTYSYORUI = new Item("khdshr", "hituyouSyoruiInfo", "vhtysdisphtysyorui", null, ErrorMsgKbn.DD);

    static final Item DDID_REFERENCEBUTTONS_SYOUKAINOMIBTN = new Item("khdshr", "referenceButtons", "syoukainomibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_REFERENCEBUTTONS_SAINYUURYOKUBTN = new Item("khdshr", "referenceButtons", "sainyuuryokubtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SKNAIYOUINFO_HAITOUKINSKKBN = new Item("khdshr", "skNaiyouInfo", "haitoukinskkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_SKNAIYOUINFO_INPUTHAITOUKINSKKNGK = new Item("khdshr", "skNaiyouInfo", "inputhaitoukinskkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_SKNAIYOUINFO_HAITOUKINSKKNGK = new Item("khdshr", "skNaiyouInfo", "haitoukinskkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_SIHARAINAIYOUINFOGK_CALCKIJYUNYMD = new Item("khdshr", "siharaiNaiyouInfoGk", "calckijyunymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SIHARAINAIYOUINFOGK_SHRYMD = new Item("khdshr", "siharaiNaiyouInfoGk", "shrymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SIHARAINAIYOUINFOGK_SHRGKGOUKEIKAKUNIN = new Item("khdshr", "siharaiNaiyouInfoGk", "shrgkgoukeikakunin", null, ErrorMsgKbn.DISP);

    static final Item DDID_SIHARAINAIYOUINFOGK_TUMITATEHAITOUGANRIKIN2 = new Item("khdshr", "siharaiNaiyouInfoGk", "tumitatehaitouganrikin2", null, ErrorMsgKbn.DD);

    static final Item DDID_SIHARAINAIYOUINFOGK_DISPTIENRSKKISANYMDNISSUU = new Item("khdshr", "siharaiNaiyouInfoGk", "disptienrskkisanymdnissuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_SIHARAINAIYOUINFOGK_SHRTIENRSK = new Item("khdshr", "siharaiNaiyouInfoGk", "shrtienrsk", null, ErrorMsgKbn.DD);

    static final Item DDID_SIHARAINAIYOUINFOGK_SHRTMTTHTKINZNDK = new Item("khdshr", "siharaiNaiyouInfoGk", "shrtmtthtkinzndk", null, ErrorMsgKbn.DD);

    static final Item DDID_SIHARAIHOUHOU_INPUTSHRHOUSITEIKBN = new Item("khdshr", "siharaihouhou", "inputshrhousiteikbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_KOUZAINFO_SOUKINSAKIKBN = new Item("khdshr", "kouzaInfo", "soukinsakikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUZAINFO_BANKCD = new Item("khdshr", "kouzaInfo", "bankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUZAINFO_BANKNMKJ = new Item("khdshr", "kouzaInfo", "banknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUZAINFO_SITENCD = new Item("khdshr", "kouzaInfo", "sitencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUZAINFO_SITENNMKJ = new Item("khdshr", "kouzaInfo", "sitennmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUZAINFO_YOKINKBN = new Item("khdshr", "kouzaInfo", "yokinkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUZAINFO_KOUZANO = new Item("khdshr", "kouzaInfo", "kouzano", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUZAINFO_KZDOUKBN = new Item("khdshr", "kouzaInfo", "kzdoukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KOUZAINFO_KZMEIGINMKN = new Item("khdshr", "kouzaInfo", "kzmeiginmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HONNININFO_HONNINKAKNINKEKKAKBN = new Item("khdshr", "honninInfo", "honninkakninkekkakbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SHSNMINFO_SHSKYNO = new Item("khdshr", "shsnmInfo", "shskyno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SHSNMINFO_SHSADR1KJ = new Item("khdshr", "shsnmInfo", "shsadr1kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SHSNMINFO_SHSADR2KJ = new Item("khdshr", "shsnmInfo", "shsadr2kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SHSNMINFO_SHSADR3KJ = new Item("khdshr", "shsnmInfo", "shsadr3kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_KEKKAINPUTGROUP_SYORIKEKKAKBN = new Item("khdshr", "kekkainputGroup", "syorikekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEKKAINPUTGROUP_SASIMODOSISAKIKBN = new Item("khdshr", "kekkainputGroup", "sasimodosisakikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEKKAINPUTGROUP_SYANAICOMMENTKH = new Item("khdshr", "kekkainputGroup", "syanaicommentkh", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("khdshr", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_MODORUBTNBYCONFIRM = new Item("khdshr", "footerButtons4", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_KAKUTEIBTN = new Item("khdshr", "footerButtons4", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS5_SYOKIGAMENHEBTN = new Item("khdshr", "footerButtons5", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS6_MODORUBTNBYSKSCONFIRM = new Item("khdshr", "footerButtons6", "modorubtnbysksconfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS6_KAKUTEIBTNBYSKSCONFIRM = new Item("khdshr", "footerButtons6", "kakuteibtnbysksconfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS7_SYOKIGAMENHEBTNBYSKSRESULT = new Item("khdshr", "footerButtons7", "syokigamenhebtnbysksresult", null, ErrorMsgKbn.DD);
}
