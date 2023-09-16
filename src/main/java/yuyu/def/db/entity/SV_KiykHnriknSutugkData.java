package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKSV_KiykHnriknSutugkData;
import yuyu.def.db.mapping.GenSV_KiykHnriknSutugkData;
import yuyu.def.db.meta.GenQSV_KiykHnriknSutugkData;
import yuyu.def.db.meta.QSV_KiykHnriknSutugkData;

/**
 * 解約返戻金相当額情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_KiykHnriknSutugkData} の JavaDoc を参照してください。
 * @see     GenSV_KiykHnriknSutugkData
 * @see     PKSV_KiykHnriknSutugkData
 * @see     QSV_KiykHnriknSutugkData
 * @see     GenQSV_KiykHnriknSutugkData
 */
@Entity
public class SV_KiykHnriknSutugkData extends GenSV_KiykHnriknSutugkData {

    private static final long serialVersionUID = 1L;

    public SV_KiykHnriknSutugkData() {
    }

    public SV_KiykHnriknSutugkData(Integer pRenno8keta) {
        super(pRenno8keta);
    }

}
