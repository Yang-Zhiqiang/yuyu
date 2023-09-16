package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKSV_SnkiykSyunyupData;
import yuyu.def.db.mapping.GenSV_SnkiykSyunyupData;
import yuyu.def.db.meta.GenQSV_SnkiykSyunyupData;
import yuyu.def.db.meta.QSV_SnkiykSyunyupData;

/**
 * 新契約収入P統計情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_SnkiykSyunyupData} の JavaDoc を参照してください。
 * @see     GenSV_SnkiykSyunyupData
 * @see     PKSV_SnkiykSyunyupData
 * @see     QSV_SnkiykSyunyupData
 * @see     GenQSV_SnkiykSyunyupData
 */
@Entity
public class SV_SnkiykSyunyupData extends GenSV_SnkiykSyunyupData {

    private static final long serialVersionUID = 1L;

    public SV_SnkiykSyunyupData() {
    }

    public SV_SnkiykSyunyupData(Integer pRenno8keta) {
        super(pRenno8keta);
    }

}
