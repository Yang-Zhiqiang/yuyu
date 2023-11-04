package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSiharaiRirekiTblParam;
import yuyu.common.siharai.edittbl.SiharaiRirekiParam;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.AbstractUiBean;

/**
 * 支払履歴TBL編集テスト用画面UiBeanクラスです。<br />
 */
@ConversationScoped
public class EditSiharaiRirekiTblTestUiBean extends AbstractUiBean implements  EditSiharaiRirekiTblParam, SiharaiRirekiParam {

    private static final long serialVersionUID = 1L;

    public EditSiharaiRirekiTblTestUiBean() {
    }

    private BizDate tyakkinymd;

    private BizCurrency shrgkkei;

    @Override
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Override
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    @Override
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    @Override
    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }
}
