package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.common.base.kadoutime.KadouTimeTableData;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.id.PKAT_KadouTime;
import yuyu.def.db.mapping.GenAT_KadouTime;
import yuyu.def.db.meta.GenQAT_KadouTime;
import yuyu.def.db.meta.QAT_KadouTime;

/**
 * 稼働時間テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_KadouTime} の JavaDoc を参照してください。
 * @see     GenAT_KadouTime
 * @see     PKAT_KadouTime
 * @see     QAT_KadouTime
 * @see     GenQAT_KadouTime
 */
@Entity
public class AT_KadouTime extends GenAT_KadouTime implements KadouTimeTableData{

    private static final long serialVersionUID = 1L;

    public AT_KadouTime() {
    }

    public AT_KadouTime(
        String pKadouTimeGroupCd,
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn,
        C_EigyoubiKbn pEigyoubiKbn
        ) {
        super(
            pKadouTimeGroupCd,
            pKadouTimeYoubiKbn,
            pEigyoubiKbn
            );
    }

    private AT_KadouTimeGroup aT_KadouTimeGroup;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn (name=AT_KadouTime.KADOUTIMEGROUPCD, referencedColumnName=AT_KadouTimeGroup.KADOUTIMEGROUPCD, insertable=false, updatable=false)
    public AT_KadouTimeGroup getKadouTimeGroup() {
        return aT_KadouTimeGroup;
    }

    void setKadouTimeGroup(AT_KadouTimeGroup pKadouTimeGroup) {
        aT_KadouTimeGroup = pKadouTimeGroup;
    }

}
