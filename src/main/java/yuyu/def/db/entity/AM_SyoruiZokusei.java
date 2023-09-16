package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.id.PKAM_SyoruiZokusei;
import yuyu.def.db.mapping.GenAM_SyoruiZokusei;
import yuyu.def.db.meta.GenQAM_SyoruiZokusei;
import yuyu.def.db.meta.QAM_SyoruiZokusei;

/**
 * 書類属性マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_SyoruiZokusei} の JavaDoc を参照してください。
 * @see     GenAM_SyoruiZokusei
 * @see     PKAM_SyoruiZokusei
 * @see     QAM_SyoruiZokusei
 * @see     GenQAM_SyoruiZokusei
 */
@Entity
public class AM_SyoruiZokusei extends GenAM_SyoruiZokusei {

    private static final long serialVersionUID = 1L;

    public AM_SyoruiZokusei() {
    }

    public AM_SyoruiZokusei(C_SyoruiCdKbn pSyoruiCd) {
        super(pSyoruiCd);
    }

}
