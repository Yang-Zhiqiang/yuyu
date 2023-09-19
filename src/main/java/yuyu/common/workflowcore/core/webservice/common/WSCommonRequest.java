package yuyu.common.workflowcore.core.webservice.common;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;

/**
 * Webサービスリクエスト 共通項目<br/>
 * 全Webサービスのリクエストに共通する項目を定義します。
 */
@SuppressWarnings("serial")
public class WSCommonRequest implements Serializable {

    @FormParam(WSCommonIOKey.IN.sS_REQUESTID)
    private String sRequestid_;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM1)
    private WSExtParam extParam1;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM2)
    private WSExtParam extParam2;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM3)
    private WSExtParam extParam3;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM4)
    private WSExtParam extParam4;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM5)
    private WSExtParam extParam5;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM6)
    private WSExtParam extParam6;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM7)
    private WSExtParam extParam7;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM8)
    private WSExtParam extParam8;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM9)
    private WSExtParam extParam9;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM10)
    private WSExtParam extParam10;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM11)
    private WSExtParam extParam11;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM12)
    private WSExtParam extParam12;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM13)
    private WSExtParam extParam13;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM14)
    private WSExtParam extParam14;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM15)
    private WSExtParam extParam15;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM16)
    private WSExtParam extParam16;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM17)
    private WSExtParam extParam17;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM18)
    private WSExtParam extParam18;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM19)
    private WSExtParam extParam19;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM20)
    private WSExtParam extParam20;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM21)
    private WSExtParam extParam21;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM22)
    private WSExtParam extParam22;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM23)
    private WSExtParam extParam23;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM24)
    private WSExtParam extParam24;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM25)
    private WSExtParam extParam25;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM26)
    private WSExtParam extParam26;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM27)
    private WSExtParam extParam27;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM28)
    private WSExtParam extParam28;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM29)
    private WSExtParam extParam29;

    @FormParam(WSCommonIOKey.IN.sS_EXTPARAM30)
    private WSExtParam extParam30;

    @JSONHint(name=WSCommonIOKey.IN.sS_REQUESTID)
    public String getRequestid() {
        return sRequestid_;
    }

    public void setRequestid(String psRequestid) {
        sRequestid_ = psRequestid;
    }


    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM1)
    public WSExtParam getExtParam1() {
        return extParam1;
    }

    @Deprecated
    public void setExtParam1(WSExtParam pExtParam1) {
        extParam1 = pExtParam1;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM2)
    public WSExtParam getExtParam2() {
        return extParam2;
    }

    @Deprecated
    public void setExtParam2(WSExtParam pExtParam2) {
        extParam2 = pExtParam2;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM3)
    public WSExtParam getExtParam3() {
        return extParam3;
    }

    @Deprecated
    public void setExtParam3(WSExtParam pExtParam3) {
        extParam3 = pExtParam3;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM4)
    public WSExtParam getExtParam4() {
        return extParam4;
    }

    @Deprecated
    public void setExtParam4(WSExtParam pExtParam4) {
        extParam4 = pExtParam4;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM5)
    public WSExtParam getExtParam5() {
        return extParam5;
    }

    @Deprecated
    public void setExtParam5(WSExtParam pExtParam5) {
        extParam5 = pExtParam5;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM6)
    public WSExtParam getExtParam6() {
        return extParam6;
    }

    @Deprecated
    public void setExtParam6(WSExtParam pExtParam6) {
        extParam6 = pExtParam6;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM7)
    public WSExtParam getExtParam7() {
        return extParam7;
    }

    @Deprecated
    public void setExtParam7(WSExtParam pExtParam7) {
        extParam7 = pExtParam7;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM8)
    public WSExtParam getExtParam8() {
        return extParam8;
    }

    @Deprecated
    public void setExtParam8(WSExtParam pExtParam8) {
        extParam8 = pExtParam8;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM9)
    public WSExtParam getExtParam9() {
        return extParam9;
    }

    @Deprecated
    public void setExtParam9(WSExtParam pExtParam9) {
        extParam9 = pExtParam9;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM10)
    public WSExtParam getExtParam10() {
        return extParam10;
    }

    @Deprecated
    public void setExtParam10(WSExtParam pExtParam10) {
        extParam10 = pExtParam10;
    }


    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM11)
    public WSExtParam getExtParam11() {
        return extParam11;
    }

    @Deprecated
    public void setExtParam11(WSExtParam pExtParam11) {
        extParam11 = pExtParam11;
    }


    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM12)
    public WSExtParam getExtParam12() {
        return extParam12;
    }

    @Deprecated
    public void setExtParam12(WSExtParam pExtParam12) {
        extParam12 = pExtParam12;
    }


    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM13)
    public WSExtParam getExtParam13() {
        return extParam13;
    }

    @Deprecated
    public void setExtParam13(WSExtParam pExtParam13) {
        extParam13 = pExtParam13;
    }


    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM14)
    public WSExtParam getExtParam14() {
        return extParam14;
    }

    @Deprecated
    public void setExtParam14(WSExtParam pExtParam14) {
        extParam14 = pExtParam14;
    }


    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM15)
    public WSExtParam getExtParam15() {
        return extParam15;
    }

    @Deprecated
    public void setExtParam15(WSExtParam pExtParam15) {
        extParam15 = pExtParam15;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM16)
    public WSExtParam getExtParam16() {
        return extParam16;
    }

    @Deprecated
    public void setExtParam16(WSExtParam pExtParam16) {
        extParam16 = pExtParam16;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM17)
    public WSExtParam getExtParam17() {
        return extParam17;
    }

    @Deprecated
    public void setExtParam17(WSExtParam pExtParam17) {
        extParam17 = pExtParam17;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM18)
    public WSExtParam getExtParam18() {
        return extParam18;
    }

    @Deprecated
    public void setExtParam18(WSExtParam pExtParam18) {
        extParam18 = pExtParam18;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM19)
    public WSExtParam getExtParam19() {
        return extParam19;
    }

    @Deprecated
    public void setExtParam19(WSExtParam pExtParam19) {
        extParam19 = pExtParam19;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM20)
    public WSExtParam getExtParam20() {
        return extParam20;
    }

    @Deprecated
    public void setExtParam20(WSExtParam pExtParam20) {
        extParam20 = pExtParam20;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM21)
    public WSExtParam getExtParam21() {
        return extParam21;
    }

    @Deprecated
    public void setExtParam21(WSExtParam pExtParam21) {
        extParam21 = pExtParam21;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM22)
    public WSExtParam getExtParam22() {
        return extParam22;
    }

    @Deprecated
    public void setExtParam22(WSExtParam pExtParam22) {
        extParam22 = pExtParam22;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM23)
    public WSExtParam getExtParam23() {
        return extParam23;
    }

    @Deprecated
    public void setExtParam23(WSExtParam pExtParam23) {
        extParam23 = pExtParam23;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM24)
    public WSExtParam getExtParam24() {
        return extParam24;
    }

    @Deprecated
    public void setExtParam24(WSExtParam pExtParam24) {
        extParam24 = pExtParam24;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM25)
    public WSExtParam getExtParam25() {
        return extParam25;
    }

    @Deprecated
    public void setExtParam25(WSExtParam pExtParam25) {
        extParam25 = pExtParam25;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM26)
    public WSExtParam getExtParam26() {
        return extParam26;
    }

    @Deprecated
    public void setExtParam26(WSExtParam pExtParam26) {
        extParam26 = pExtParam26;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM27)
    public WSExtParam getExtParam27() {
        return extParam27;
    }

    @Deprecated
    public void setExtParam27(WSExtParam pExtParam27) {
        extParam27 = pExtParam27;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM28)
    public WSExtParam getExtParam28() {
        return extParam28;
    }

    @Deprecated
    public void setExtParam28(WSExtParam pExtParam28) {
        extParam28 = pExtParam28;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM29)
    public WSExtParam getExtParam29() {
        return extParam29;
    }

    @Deprecated
    public void setExtParam29(WSExtParam pExtParam29) {
        extParam29 = pExtParam29;
    }

    @JSONHint(name=WSCommonIOKey.IN.sS_EXTPARAM29)
    public WSExtParam getExtParam30() {
        return extParam30;
    }

    @Deprecated
    public void setExtParam30(WSExtParam pExtParam30) {
        extParam30 = pExtParam30;
    }
}