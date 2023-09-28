package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TodouhukenKbn;

/**
 * 業務共通 共通 住所情報取得
 */
public class GetAdrData {

    private static final String BLANK = "";

    private C_ErrorKbn errorKbn;

    private String adr1;

    private String adr2;

    private String adr3;

    private String adrKana1;

    private String adrKana2;

    private String adrKana3;

    private C_TodouhukenKbn todouhukenKbn;

    @Inject
    private BaseDomManager baseDomManager;

    public GetAdrData() {
        super();
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public String getAdr1() {
        return adr1;
    }

    public String getAdr2() {
        return adr2;
    }

    public String getAdr3() {
        return adr3;
    }

    public String getAdrKana1() {
        return adrKana1;
    }

    public String getAdrKana2() {
        return adrKana2;
    }

    public String getAdrKana3() {
        return adrKana3;
    }

    public C_TodouhukenKbn getTodouhukenKbn() {
        return todouhukenKbn;
    }

    public void exec(String pYno) {
//      if (!StringUtil.isDigit(pYno) || pYno.length()!= 7) {
//          errorKbn = C_ErrorKbn.ERROR;
//          adrKana1 = BLANK;
//          adrKana2 = BLANK;
//          adrKana3 = BLANK;
//          adr1 = BLANK;
//          adr2 = BLANK;
//          adr3 = BLANK;
//          todouhukenKbn = C_TodouhukenKbn.BLNK;
//          return;
//      }
//
//      BM_Address address = baseDomManager.getAddress(pYno);
//      if (address == null) {
//          errorKbn = C_ErrorKbn.ERROR;
//          adrKana1 = BLANK;
//          adrKana2 = BLANK;
//          adrKana3 = BLANK;
//          adr1 = BLANK;
//          adr2 = BLANK;
//          adr3 = BLANK;
//          todouhukenKbn = C_TodouhukenKbn.BLNK;
//      }
//      else {
//          errorKbn = C_ErrorKbn.OK;
//          adrKana1 = address.getTodoufukenNmKana();
//          adrKana2 = address.getSikutyousonNmKana();
//          adrKana3 = address.getTyouikiNmKana();
//          adr1 = address.getTodoufukenNm();
//          adr2 = address.getSikutyousonNm();
//          adr3 = address.getTyouikiNm();
//          todouhukenKbn = address.getTodouhukenKbn();
//      }
    }
}