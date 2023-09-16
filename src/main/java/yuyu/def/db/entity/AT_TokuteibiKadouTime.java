package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.common.base.kadoutime.KadouTimeTableData;
import yuyu.def.db.id.PKAT_TokuteibiKadouTime;
import yuyu.def.db.mapping.GenAT_TokuteibiKadouTime;
import yuyu.def.db.meta.GenQAT_TokuteibiKadouTime;
import yuyu.def.db.meta.QAT_TokuteibiKadouTime;

/**
 * 特定日稼働時間テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_TokuteibiKadouTime} の JavaDoc を参照してください。
 * @see     GenAT_TokuteibiKadouTime
 * @see     PKAT_TokuteibiKadouTime
 * @see     QAT_TokuteibiKadouTime
 * @see     GenQAT_TokuteibiKadouTime
 */
@Entity
public class AT_TokuteibiKadouTime extends GenAT_TokuteibiKadouTime implements KadouTimeTableData{

    private static final long serialVersionUID = 1L;

    public AT_TokuteibiKadouTime() {
    }

    public AT_TokuteibiKadouTime(String pKadouTimeGroupCd, BizDate pKadouTimeSiteiYmd) {
        super(pKadouTimeGroupCd, pKadouTimeSiteiYmd);
    }

    private AT_KadouTimeGroup aT_KadouTimeGroup;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_TokuteibiKadouTime.KADOUTIMEGROUPCD, referencedColumnName=AT_KadouTimeGroup.KADOUTIMEGROUPCD, insertable=false, updatable=false)
    public AT_KadouTimeGroup getKadouTimeGroup() {
        return aT_KadouTimeGroup;
    }

    void setKadouTimeGroup(AT_KadouTimeGroup pKadouTimeGroup) {
        aT_KadouTimeGroup = pKadouTimeGroup;
    }

}
