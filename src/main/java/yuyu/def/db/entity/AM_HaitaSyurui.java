package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAM_HaitaSyurui;
import yuyu.def.db.mapping.GenAM_HaitaSyurui;
import yuyu.def.db.meta.GenQAM_HaitaSyurui;
import yuyu.def.db.meta.QAM_HaitaSyurui;

/**
 * 排他種類マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_HaitaSyurui} の JavaDoc を参照してください。
 * @see     GenAM_HaitaSyurui
 * @see     PKAM_HaitaSyurui
 * @see     QAM_HaitaSyurui
 * @see     GenQAM_HaitaSyurui
 */
@Entity
public class AM_HaitaSyurui extends GenAM_HaitaSyurui {

    private static final long serialVersionUID = 1L;

    public AM_HaitaSyurui() {
    }

    public AM_HaitaSyurui(String pHaitaSyuruiCd) {
        super(pHaitaSyuruiCd);
    }

}
