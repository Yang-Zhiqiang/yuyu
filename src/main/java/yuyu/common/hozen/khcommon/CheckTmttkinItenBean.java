package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 契約保全共通 積立金移転共通チェックBean
 */
public class CheckTmttkinItenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate syoruiukeymd;

    private C_Tmttknitenkbn tmttknitenkbn;

    private BizDate tmttknitenymd;

    private IT_KykKihon kykKihon;

    public CheckTmttkinItenBean() {
        super();
    }

    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    public C_Tmttknitenkbn getTmttknitenkbn() {
        return tmttknitenkbn;
    }

    public void setTmttknitenkbn(C_Tmttknitenkbn pTmttknitenkbn) {
        tmttknitenkbn = pTmttknitenkbn;
    }

    public BizDate getTmttknitenymd() {
        return tmttknitenymd;
    }

    public void setTmttknitenymd(BizDate pTmttknitenymd) {
        tmttknitenymd = pTmttknitenymd;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }
}
