package yuyu.batch.hozen.khansyuu.khgentumiskmikomirituulfsks.dba;

import java.io.Serializable;

import yuyu.def.classification.C_Syoumetujiyuu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 案内収納  限積用失効見込率算出用ＵＬＦ作成
 */
public class GentumiSkMikomirituULFBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_Syoumetujiyuu  syoumetujiyuu;

    @Getter @Setter
    private BizDate syoumetuymd;


    public GentumiSkMikomirituULFBean(
        String pSyono,
        C_Syoumetujiyuu pSyoumetujiyuu,
        BizDate pSyoumetuymd) {

        syono = pSyono;
        syoumetujiyuu = pSyoumetujiyuu;
        syoumetuymd = pSyoumetuymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
