package yuyu.common.suuri.suuricommon;

import java.io.Serializable;

import yuyu.def.classification.C_SyouhinJyouhouGetKbn;

/**
 * 数理統計 数理共通 特定時点契約商品レコードBeanクラス
 */
public class TkJitenKeiyakuSyouhinBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyouhinJyouhouGetKbn syouhinJyouhouGetKbnAto;

    private TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto;

    private C_SyouhinJyouhouGetKbn syouhinJyouhouGetKbnMae;

    private TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanMae;

    public TkJitenKeiyakuSyouhinBean() {
        super();

        syouhinJyouhouGetKbnAto = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
        tkJitenKeiyakuSyouhinKijyunBeanAto = null;
        syouhinJyouhouGetKbnMae = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
        tkJitenKeiyakuSyouhinKijyunBeanMae = null;
    }

    public C_SyouhinJyouhouGetKbn getSyouhinJyouhouGetKbnAto() {
        return syouhinJyouhouGetKbnAto;
    }

    public void setSyouhinJyouhouGetKbnAto(C_SyouhinJyouhouGetKbn pSyouhinJyouhouGetKbnAto) {
        this.syouhinJyouhouGetKbnAto = pSyouhinJyouhouGetKbnAto;
    }

    public TkJitenKeiyakuSyouhinKijyunBean getTkJitenKeiyakuSyouhinKijyunBeanAto() {
        return tkJitenKeiyakuSyouhinKijyunBeanAto;
    }

    public void setTkJitenKeiyakuSyouhinKijyunBeanAto(TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBeanAto) {
        this.tkJitenKeiyakuSyouhinKijyunBeanAto = pTkJitenKeiyakuSyouhinKijyunBeanAto;
    }

    public C_SyouhinJyouhouGetKbn getSyouhinJyouhouGetKbnMae() {
        return syouhinJyouhouGetKbnMae;
    }

    public void setSyouhinJyouhouGetKbnMae(C_SyouhinJyouhouGetKbn pSyouhinJyouhouGetKbnMae) {
        this.syouhinJyouhouGetKbnMae = pSyouhinJyouhouGetKbnMae;
    }

    public TkJitenKeiyakuSyouhinKijyunBean getTkJitenKeiyakuSyouhinKijyunBeanMae() {
        return tkJitenKeiyakuSyouhinKijyunBeanMae;
    }

    public void setTkJitenKeiyakuSyouhinKijyunBeanMae(TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBeanMae) {
        this.tkJitenKeiyakuSyouhinKijyunBeanMae = pTkJitenKeiyakuSyouhinKijyunBeanMae;
    }
}
