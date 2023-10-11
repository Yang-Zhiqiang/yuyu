package createdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateDataConstants {

    static String IT_KouteiSummary_sql = "UPDATE IT_KouteiSummary SET (lastSyoriTime, zenkaiAccountId, zenkaiNodeNm, nodeNm, kouteiKanryouYmd, syoriStatus) VALUES (";
    static String IT_KykSya_sql = "INSERT INTO IT_KykSya (syono, kokno, kyknmkn, kyknmkj, kyknmkjkhukakbn, kykseiymd, kyksei, kkkyktdk, tsinyno, tsinadr1kn, tsinadr1kj, tsinadr2kn, tsinadr2kj, tsinadr3kn, tsinadr3kj, tsinadr4kn, tsinadr4kj, tsintelno, nittyuutelno, tsinmailaddress, kinmusakinm, hjndaiykkbn, hjndaiyknm, hjndainmkn, hjndainmkj, gyoumuKousinKinou, gyoumuKousinsyaId, gyoumuKousinTime, KOUSINSYAID, KOUSINTIME, KOUSINKINOU, VERSION) VALUES (";
    static String IT_KykSyouhn_sql = "INSERT INTO IT_KykSyouhn (syono, syutkkbn, syouhncd, syouhnsdno, kyksyouhnrenno, henkousikibetukey, yuukousyoumetukbn, kykjyoutai, syoumetujiyuu, syoumetuymd, kouryokuhasseiymd, kykymd, kykymdsiteiumukbn, sknnkaisiymd, gansknnkaisiymd, hksknnkaisiymd, hkgansknnkaisiymd, hknkknsmnkbn, hknkkn, hrkkknsmnkbn, hrkkkn, kyknen, hhknnen, haraimanymd, hknkknmanryouymd, katakbn, kyhgndkatakbn, syukyhkinkatakbn, khnkyhkgbairitukbn, rokudaildkbn, pmnjtkkbn, kihons, kihons$, hokenryou, hokenryou$, yennyknratekjymd, yennyknrate, yennyknkgk, yennyknkgk$, gyoumuKousinKinou, gyoumuKousinsyaId, gyoumuKousinTime, KOUSINSYAID, KOUSINTIME, KOUSINKINOU, VERSION) VALUES (";
    static String comma = ", ";
    static String quoat = "'";
    static String right = ")";
    static String semicoron = ";";
    static String null_str = "NULL";
    static String filepath = "D:/develop/reps/bazaar/sql/";
    static String dirpath1 = "4_1/";
    static String dirpath2 = "4_2/";
    static String dirpath3 = "4_3/";
    static String dirpath4 = "4_4/";
    static String filename_JBPM_PROCESSINSTANCE_INSERT = "JBPM_PROCESSINSTANCE_insert.sql";
    static String filename_JBPM_PROCESSINSTANCE_UPDATE = "JBPM_PROCESSINSTANCE_update.sql";
    static String filename_JBPM_TOKEN_INSERT = "JBPM_TOKEN_insert.sql";
    static String filename_JBPM_TOKEN_UPDATE = "JBPM_TOKEN_update.sql";
    static String filename_JBPM_MODULEINSTANCE_INSERT = "01_JBPM_MODULEINSTANCE_insert.sql";
    static String filename_JBPM_TOKENVARIABLEMAP_INSERT = "02_JBPM_TOKENVARIABLEMAP_insert.sql";
    static String filename_JBPM_TASKINSTANCE_INSERT = "01_JBPM_TASKINSTANCE_insert.sql";
    static String filename_JBPM_VARIABLEINSTANCE_INSERT = "02_JBPM_VARIABLEINSTANCE_insert.sql";
    static String filename_IT_ImageArriveNotice_INSERT = "IT_ImageArriveNotice_insert.sql";
    static String filename_IT_GyoumuKey_INSERT = "IT_GyoumuKey_insert.sql";
    static String filename_IT_PDFHozon_INSERT = "IT_PDFHozon_insert.sql";
    static String filename_IT_Page_INSERT = "IT_Page_insert.sql";
    static String filename_IT_TorikomiKanri_INSERT = "IT_TorikomiKanri_insert.sql";
    static String filename_IT_TorikomiRelation_INSERT = "IT_TorikomiRelation_insert.sql";
    static String filename_IT_KouteiSummary_INSERT = "IT_KouteiSummary_insert.sql";
    static String filename_IT_KouteiRireki_INSERT = "IT_KouteiRireki_insert.sql";
    static final long ACTIVEPROCESS_NUM = 500;
    static final long JIMUYOUCODE_NUM = 1000;
    static final long cnt_max = 250000;
    //    static String gyoumuKey = "70000000";

    static String JBPM_PROCESSINSTANCE_INSERT = "INSERT INTO JBPM_PROCESSINSTANCE (id_, version_, key_, start_, end_, isSuspended_, processDefinition_, rootToken_, superProcessToken_) VALUES (";
    static String JBPM_PROCESSINSTANCE_UPDATE = "UPDATE JBPM_PROCESSINSTANCE SET (rootToken_) = (";
    static String JBPM_UPDATE_WHERE = ") WHERE id_ = ";
    static String JBPM_TOKEN_INSERT = "INSERT INTO JBPM_TOKEN (id_, version_, name_, start_, end_, nodeEnter_, nextLogIndex_, isAbleToReactivateParent_, isTerminationImplicit_, node_, isSuspended_, lock_, processInstance_, parent_, subProcessInstance_) VALUES (";
    static String JBPM_TOKEN_UPDATE = "UPDATE JBPM_TOKEN SET (processInstance_) = (";
    static String JBPM_MODULEINSTANCE_INSERT = "INSERT INTO JBPM_MODULEINSTANCE (ID_, CLASS_, VERSION_, PROCESSINSTANCE_, TASKMGMTDEFINITION_, NAME_) VALUES (";
    static String JBPM_TOKENVARIABLEMAP_INSERT = "INSERT INTO JBPM_TOKENVARIABLEMAP (id_, version_, token_, contextInstance_) VALUES (";
    static String JBPM_TASKINSTANCE_INSERT = "INSERT INTO JBPM_TASKINSTANCE (id_, class_, version_, name_, description_, actorId_, create_, start_, end_, dueDate_, priority_, isCancelled_, isSuspended_, isOpen_, isSignalling_, isBlocking_, task_, token_, procInst_, swimlanInstance_, taskMgmtInstance_) VALUES (";
    static String JBPM_VARIABLEINSTANCE_INSERT = "INSERT INTO JBPM_VARIABLEINSTANCE (id_, class_, version_, name_, converter_, token_, tokenVariableMap_, processInstance_, byteArrayValue_, dateValue_, doubleValue_, longIdClass_, longValue_, stringIdClass_, stringValue_, taskInstance_) VALUES (";
    static String IT_ImageArriveNotice_INSERT = "INSERT INTO IT_ImageArriveNotice (arriveKey, torikomiSyoruiCd, gyoumuKey, flowId, subSystemId) VALUES (";
    static String IT_GyoumuKey_INSERT = "INSERT INTO IT_GyoumuKey (flowId, gyoumuKey, tokenId, createTime) VALUES (";
    static String IT_PDFHozon_INSERT = "INSERT INTO IT_PDFHozon (imageId, pageId, pdfData) VALUES (";
    static String IT_Page_INSERT = "INSERT INTO IT_Page (imageId, syoruiToutyakuTime, pageNo, pageId, torikomiSousasyaId) VALUES (";
    static String IT_TorikomiKanri_INSERT = "INSERT INTO IT_TorikomiKanri (imageId, torikomiSyoruiCd, tourokuId, tourokuTime, extParam1, extParam2, extParam3, extParam4, extParam5, extParam6, extParam7, extParam8, extParam9, extParam10, extParam11, extParam12, extParam13, extParam14, extParam15) VALUES (";
    static String IT_TorikomiRelation_INSERT = "INSERT INTO IT_TorikomiRelation (imageId, gyoumuKey) VALUES (";
    static String IT_KouteiSummary_INSERT = "INSERT INTO IT_KouteiSummary (gyoumuKey, flowId, lastSyoriTime, syokaiAccountId, zenkaiAccountId, zenkaiNodeNm, zenkaiTaskLocalNm, nodeNm, genzaiAccountId, genzaiTaskLocalNm, kouteiKaisiYmd, kouteiKanryouYmd, syoriStatus, extParam1, extParam2, extParam3, extParam4, extParam5, extParam6, extParam7, extParam8, extParam9, extParam10, extParam11, extParam12, extParam13, extParam14, extParam15) VALUES (";
    static String IT_KouteiRireki_INSERT = "INSERT INTO IT_KouteiRireki (tokenId, gyoumuKey, rirekiKbn, syoriTime, flowId, nodeId, nodeNm, accountId, syoriKbn, rrkMsg, extInfo) VALUES (";






    static int PROCESS_INSTANCE = 10000000;

    static int ROOT_TOKEN = 20000000;

    static int CONTEXT_INSTANCE = 30000000;

    static int TASKMNG_INSTANCE = 35000000;

    static int TOKEN_VARIABLE_MAP = 40000000;

    static int TASK_INSTANCE = 50000000;

    static int VARIABLE_INSTANCE = 100000000;

    static int ARRIVE_KEY = 60000000;

    static int GYOUMU_KEY = 70000000;

    static int IMAGE_ID = 80000000;

    static int PAGE_ID = 90000000;

    static String SYONO_UPPER = "90000";

    static int SYONO_LOWER = 000000;


    static String KEY_PROCESSDEFINITION = "processDefinition_";

    static String KEY_NODE = "node_";

    static String KEY_ENDNODE = "endnode_";

    static String KEY_TASKMGMTDEFINITION = "TASKMGMTDEFINITION_";

    static String KEY_NAME = "name_";

    static String KEY_TASK = "task_";

    static String KEY_FLOWID = "flowId";

    static String KEY_RIREKINODEID = "rirekiId";

    static List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();

    static String[] PROCESSDEFINITIONARRAY = {
        "190",
        "175",
        "232",
        "217",
        "274",
        "259",
        "316",
        "301",
        "349",
        "334"
    };

    static String[] NODEARRAY = {
        "193",
        "178",
        "237",
        "222",
        "279",
        "264",
        "321",
        "306",
        "354",
        "339"
    };

    static String[] ENDNODEARRAY = {
        "205",
        "187",
        "247",
        "229",
        "289",
        "271",
        "331",
        "313",
        "364",
        "346"
    };

    static String[] TASKMGMTDEFINITIONARRAY = {
        "207",
        "189",
        "249",
        "231",
        "291",
        "273",
        "333",
        "315",
        "366",
        "348"
    };

    static String[] NAMEARRAY = {
        "naiyoukakunin",
        "hubikaisyou",
        "naiyoukakunin",
        "hubikaisyou",
        "naiyoukakunin",
        "hubikaisyou",
        "naiyoukakunin",
        "hubikaisyou",
        "naiyoukakunin",
        "hubikaisyou"
    };

    static String[] TASKARRAY = {
        "195",
        "180",
        "239",
        "224",
        "281",
        "266",
        "323",
        "308",
        "356",
        "341"
    };

    static String[] FLOWIDARRAY = {
        "jshk",
        "jsh1",
        "kiyk",
        "kiy1",
        "kyhk",
        "kyh1",
        "mghk",
        "mgh1",
        "msmk",
        "msm1"
    };

    static String[] RIREKINODEIDARRAY = {
        "199.193",
        "181.178",
        "237.235",
        "222.220",
        "279.277",
        "264.262",
        "321.319",
        "306.304",
        "354.352",
        "339.337"
    };


    @SuppressWarnings("serial")
    public static final Map<String, String> FLOWNMMAP = new HashMap<String, String>(){
        {
            put("clof", "クーリングオフ");
        }
        {
            put("gnm1", "不備（がん無効）");
        }
        {
            put("gnmk", "がん無効");
        }
        {
            put("hkt1", "不備（復活）");
        }
        {
            put("hkts", "復活");
        }
        {
            put("hrh1", "不備（払込方法変更）");
        }
        {
            put("hrhk", "払込方法変更");
        }
        {
            put("jsh1", "不備（住所変更）");
        }
        {
            put("jshk", "住所変更");
        }
        {
            put("kijy", "解除");
        }
        {
            put("kiy1", "不備（解約）");
        }
        {
            put("kiyk", "解約");
        }
        {
            put("kssh", "控除証明書再発行");
        }
        {
            put("kyh1", "不備（契約変更）");
        }
        {
            put("kyhk", "契約変更");
        }
        {
            put("kytk", "契約取消");
        }
        {
            put("mgh1", "不備（名義変更）");
        }
        {
            put("mghk", "名義変更");
        }
        {
            put("msm1", "不備（申出無効）");
        }
        {
            put("msmk", "申出無効");
        }
        {
            put("muko", "無効");
        }
        {
            put("sbk1", "不備（死亡解除）");
        }
        {
            put("sbkj", "死亡解除");
        }
        {
            put("sbm1", "不備（死亡免責）");
        }
        {
            put("sbms", "死亡免責");
        }
        {
            put("sks1", "不備（証券再発行）");
        }
        {
            put("sksh", "証券再発行");
        }
        {
            put("sst1", "不備（生年月日・性訂正）");
        }
        {
            put("ssts", "生年月日・性訂正");
        }
    };

}
