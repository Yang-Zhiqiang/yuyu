package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.collect.Lists;

/**
 * {@link KhozenCommonParam}のモッククラスです。<br />
 */
public class KhozenCommonParamMock extends KhozenCommonParam {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public String getSikibetuKey(String pSyoNo) {

        if (caller == EditKykSyhnRirekiTblTest_exec_A1.class && TESTPATTERN1.equals(SYORIPTN)) {
            return "2";
        }
        else if(caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editTBL1.class
            || caller == EditTtdkKanryouTblTest_editTBL2.class || caller == EditTtdkKanryouTblTest_editTBL3.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "20151201102134233";
            }
            return super.getSikibetuKey(pSyoNo);
        }
        else if(caller == EditKaiyakuTblUpdateTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "1001";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "2001";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return "3001";
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return "4001";
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return "5001";
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return "6001";
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return "7001";
            }
        }

        return super.getSikibetuKey(pSyoNo);
    }

    @Override
    public String getFunctionId() {

        if (caller == EditKhMisslstTblTest_editBean.class) {
            return "EditKhMisslstTbl";
        }
        else if (caller == EditTtdkRirekiTblTest_exec.class && baseUserInfo.getUser().getUserId() == "king") {
            return "KhozenCommonParam";
        } else if (caller == EditTtdkRirekiTblTest_exec.class && baseUserInfo.getUser().getUserId() == "Quen") {
            return "EditTtdkRirekiTbl";
        }
        else if (caller == EditKykSyhnRirekiTblTest_exec_A1.class) {
            return "EditKykSyhnRirekiTbl";
        }
        else if(caller == EditSouhuannaiTblTest_editBean.class && TESTPATTERN1.equals(SYORIPTN)){
            return "khsouhuannaisakusei";
        }
        else if(caller == EditSouhuannaiTblTest_editBean.class && TESTPATTERN4.equals(SYORIPTN)){
            return "khkaiyaku";
        }
        else if(caller == EditDairitenTesuuryouTblTest_exec_A1.class && TESTPATTERN1.equals(SYORIPTN)){
            return "EditDairitenTesuuryouTbl";
        }
        else if(caller == EditDairitenTesuuryouTblTest_exec_A1.class && TESTPATTERN2.equals(SYORIPTN)){
            return "khseinengappiseiteisei";
        }
        else if(caller == EditDairitenTesuuryouTblTest_exec_A1.class && TESTPATTERN3.equals(SYORIPTN)){
            return "khgengaku";
        }
        else if(caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)){
            return "EditPdfHubiTyouhyou";
        }
        else if(caller == EditKoujyoSyoumeiTblTest_editTBL.class || caller == EditKoujyoSyoumeiTblTest_editBean.class){
            return "EditKoujyoSyoumeiTbl";
        }
        else if(caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editBean.class
            || caller == EditTtdkKanryouTblTest_editTBL1.class || caller == EditTtdkKanryouTblTest_editBean1.class
            || caller == EditTtdkKanryouTblTest_editTBL2.class || caller == EditTtdkKanryouTblTest_editBean2.class
            || caller == EditTtdkKanryouTblTest_editTBL3.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "EditTtdkKanryouTbl";
            }
            return super.getFunctionId();
        }
        else if(caller == EditJimuRenrakuhyouTblTest_editBean.class){
            return "EditJimuRenrakuhyouTbl";

        }
        else if(caller == EditKaiyakuTblUpdateTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "khsyoukenmeisailistsks";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "khkaiyaku";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return "khsyoukenmeisailistsks";
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return "khkaiyaku";
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return "khsyoukenmeisailistsks";
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return "khsyoukenmeisailistsks";
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return "khpminyuusyoumetu";
            }
        }
        else if(caller == KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean.class){
            return "KoujyoSyoumeiUtil";

        }
        else if(caller == EditMinyuuTuutiTest_editTBL.class){
            return "EditMinyuuTuuti";

        }
        return super.getFunctionId();
    }

    @Override
    public String getUserID() {

        if (caller == EditKykSyhnRirekiTblTest_exec_A1.class) {
            return "A0000001";
        }
        else if (caller == EditDairitenTesuuryouTblTest_exec_A1.class) {
            return "khcommon";
        }
        else if(caller == EditKoujyoSyoumeiTblTest_editTBL.class){
            return "Y001";
        }
        else if(caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editTBL1.class
            || caller == EditTtdkKanryouTblTest_editTBL2.class || caller == EditTtdkKanryouTblTest_editTBL3.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "Y001";
            }
            return super.getUserID();
        }
        else if(caller == EditJimuRenrakuhyouTblTest_editBean.class){
            return "cd";

        }
        else if(caller == EditKaiyakuTblUpdateTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "wmh";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "wmh2";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return "wmh3";
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return "wmh4";
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return "wmh5";
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return "wmh6";
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return "wmh7";
            }
        }
        else if(caller == KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean.class){
            return "testUser";

        }
        else if(caller == EditMinyuuTuutiTest_editTBL.class){
            return "testUser";

        }
        return super.getUserID();
    }

    @Override
    public String getUserNm() {

        if(caller == EditTtdkKanryouTblTest_editBean.class || caller == EditTtdkKanryouTblTest_editBean1.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "Y001";
            }
            return super.getUserNm();
        }
        if(caller == EditJimuRenrakuhyouTblTest_editBean.class){
            return "小野";
        }
        else if(caller == KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean.class){
            return "テストユーザ";

        }
        return super.getUserNm();
    }

    @Override
    public String getCategoryId() {
        if (caller == EditKhMisslstTblTest_editBean.class) {
            return "khcommon";
        }
        else if(caller == EditSouhuannaiTblTest_editBean.class){
            return "khcommon";
        }
        else if(caller == EditPdfHubiTyouhyouTest_exec.class){
            return "khcommon";
        }
        else if(caller == EditKoujyoSyoumeiTblTest_editBean.class){
            return "khcommon";
        }
        else if(caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editBean.class
            || caller == EditTtdkKanryouTblTest_editTBL1.class || caller == EditTtdkKanryouTblTest_editBean1.class
            || caller == EditTtdkKanryouTblTest_editTBL2.class || caller == EditTtdkKanryouTblTest_editBean2.class
            || caller == EditTtdkKanryouTblTest_editTBL3.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "khcommon";
            }
            return super.getCategoryId();
        }
        else if(caller == EditJimuRenrakuhyouTblTest_editBean.class){
            return "khcommon";

        }
        else if(caller == KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean.class){
            return "khcommon";

        }
        return super.getCategoryId();
    }

    @Override
    public String getKinouNm() {
        if (caller == EditKhMisslstTblTest_editBean.class) {
            return "ミスリストTBL編集";
        }
        else if(caller == EditJimuRenrakuhyouTblTest_editBean.class){
            return "事務連絡票TBL編集";

        }
        else if(caller == KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean.class){
            return "控除証明ユーティリティ";

        }
        return super.getKinouNm();
    }

    @Override
    public String getTmSosikiCd() {
        if (caller == EditSouhuannaiTblTest_editBean.class) {
            return "test01";
        }
        else if(caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editBean.class
            || caller == EditTtdkKanryouTblTest_editTBL1.class || caller == EditTtdkKanryouTblTest_editBean1.class
            || caller == EditTtdkKanryouTblTest_editTBL2.class || caller == EditTtdkKanryouTblTest_editBean2.class
            || caller == EditTtdkKanryouTblTest_editTBL3.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "0010001";
            }
            return baseUserInfo.getTmSosikiCd();
        }
        else if (caller ==  EditSeikyuusyoTblTest_editBean.class && TESTPATTERN1.equals(SYORIPTN)) {
            return  "6620000";
        }
        else if(caller == EditTtdkRirekiTblTest_exec.class){
            return "0010001";
        }
        else if(caller == EditKaiyakuTblUpdateTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "1999999";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "2999999";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return "3999999";
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return "4999999";
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return "5999999";
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return "6999999";
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return "7999999";
            }
        }
        return baseUserInfo.getTmSosikiCd();
    }

    @Override
    public String getTmSosikiNm() {

        if (caller ==  EditSeikyuusyoTblTest_editBean.class && TESTPATTERN1.equals(SYORIPTN)) {
            return  "組織００１０００１";
        }
        return baseUserInfo.getTmSosikiNm();
    }

    @Override
    public List<IT_NyknJissekiRireki> getNyknJissekiRirekiSk(String pSyoNo) {
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = Lists.newArrayList();
        if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            if ("99809111286".equals(pSyoNo) || "99809111242".equals(pSyoNo) || "17806000024".equals(pSyoNo)
                || "17806000046".equals(pSyoNo) || "17806000057".equals(pSyoNo) || "17806000105".equals(pSyoNo)
                || "17806000127".equals(pSyoNo) || "17806000138".equals(pSyoNo) || "17806000149".equals(pSyoNo)
                || "17806000150".equals(pSyoNo) || "17806000161".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.USD);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("99809111297".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.JPY);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("99809111301".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.AUD);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("99809111275".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.JPY);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("99809111390".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.USD);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("31809111338".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("31809111110".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.AUD);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("31809111121".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.BLNK);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("31809111132".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            } else if ("31809111143".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("31809111497".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.JPY);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("31809111501".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.USD);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("31809111512".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.JPY);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("31809111523".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.JPY);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("31809111534".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("31809111545".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.AUD);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("17806000068".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("17806000079".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("17806000080".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("17806000091".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("17806000116".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.EUR);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("17806000161".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.BLNK);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            else if ("99806011116".equals(pSyoNo) || "99806011127".equals(pSyoNo) || "99806011138".equals(pSyoNo) || "99806011149".equals(pSyoNo)
                || "31809111545".equals(pSyoNo) || "17806000183".equals(pSyoNo) ||  "17806000194".equals(pSyoNo) ||  "17806000208".equals(pSyoNo)) {
                IT_NyknJissekiRireki nyknJissekiRireki = new IT_NyknJissekiRireki(pSyoNo, BizDateYM.valueOf("201706"),
                    1);
                nyknJissekiRireki.setRyosyuymd(BizDate.valueOf("20170701"));
                nyknJissekiRireki.setRsgaku(BizCurrency.valueOf(1230));
                nyknJissekiRireki.setRstuukasyu(C_Tuukasyu.JPY);
                nyknJissekiRirekiLst.add(nyknJissekiRireki);
            }
            return nyknJissekiRirekiLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            nyknJissekiRirekiLst = null;
            return nyknJissekiRirekiLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            nyknJissekiRirekiLst = Lists.newArrayList();
            return nyknJissekiRirekiLst;
        }
        return super.getNyknJissekiRirekiSk(pSyoNo);
    }

    @Override
    public IT_KykSya getKeiyakusya(String pSyoNo) {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                IT_KykSya kykSya = new IT_KykSya();
                kykSya.setTsinyno("1011001");
                return kykSya;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                IT_KykSya kykSya = new IT_KykSya();
                kykSya.setTsinyno("4044004");
                return kykSya;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                IT_KykSya kykSya = new IT_KykSya();
                kykSya.setTsinyno("5055005");
                return kykSya;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                IT_KykSya kykSya = new IT_KykSya();
                kykSya.setTsinyno("6066006");
                return kykSya;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                IT_KykSya kykSya = new IT_KykSya();
                kykSya.setTsinyno("7066006");
                return kykSya;
            }
        }
        return super.getKeiyakusya(pSyoNo);
    }
}
