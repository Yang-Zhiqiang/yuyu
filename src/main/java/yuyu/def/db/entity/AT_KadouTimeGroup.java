package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import jp.co.slcs.swak.date.BizDate;

import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.id.PKAT_KadouTimeGroup;
import yuyu.def.db.mapping.GenAT_KadouTimeGroup;
import yuyu.def.db.meta.GenQAT_KadouTimeGroup;
import yuyu.def.db.meta.QAT_KadouTimeGroup;

import com.google.common.collect.Lists;

/**
 * 稼働時間グループテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_KadouTimeGroup} の JavaDoc を参照してください。
 * @see     GenAT_KadouTimeGroup
 * @see     PKAT_KadouTimeGroup
 * @see     QAT_KadouTimeGroup
 * @see     GenQAT_KadouTimeGroup
 */
@Entity
public class AT_KadouTimeGroup extends GenAT_KadouTimeGroup {

    private static final long serialVersionUID = 1L;

    public AT_KadouTimeGroup() {
    }

    public AT_KadouTimeGroup(String pKadouTimeGroupCd) {
        super(pKadouTimeGroupCd);
    }

    private AT_HolidayGroup aT_HolidayGroup;

    @ManyToOne
    @JoinColumn(name=AT_KadouTimeGroup.HOLIDAYGROUPCD, referencedColumnName=AT_HolidayGroup.HOLIDAYGROUPCD, insertable=false, updatable=false)
    public AT_HolidayGroup getHolidayGroup() {
        return aT_HolidayGroup;
    }

    public void setHolidayGroup(AT_HolidayGroup pHolidayGroup) {
        aT_HolidayGroup = pHolidayGroup;
    }

    private List<AT_TokuteibiKadouTime> aT_TokuteibiKadouTimes = Lists.newLinkedList();

    public AT_TokuteibiKadouTime createTokuteibiKadouTime() {
        AT_TokuteibiKadouTime aT_TokuteibiKadouTime = new AT_TokuteibiKadouTime();
        aT_TokuteibiKadouTime.setKadouTimeGroup(this);
        aT_TokuteibiKadouTime.setKadouTimeGroupCd(this.getKadouTimeGroupCd());
        getTokuteibiKadouTimes().add(aT_TokuteibiKadouTime);
        return aT_TokuteibiKadouTime;
    }

    @OneToMany(
        cascade       = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_TokuteibiKadouTime.KADOUTIMEGROUPCD, referencedColumnName=AT_KadouTimeGroup.KADOUTIMEGROUPCD, insertable=false,updatable=false)
    public List<AT_TokuteibiKadouTime> getTokuteibiKadouTimes() {
        return aT_TokuteibiKadouTimes;
    }

    public void setTokuteibiKadouTimes(List<AT_TokuteibiKadouTime> pTokuteibiKadouTimes) {
        aT_TokuteibiKadouTimes = pTokuteibiKadouTimes;
    }

    public AT_TokuteibiKadouTime getTokuteibiKadouTime(BizDate pKadouTimeSiteiYmd) {
        for (AT_TokuteibiKadouTime tokuteibiKadouTime : getTokuteibiKadouTimes()) {
            if (tokuteibiKadouTime.getKadouTimeSiteiYmd().equals(pKadouTimeSiteiYmd)) {
                return tokuteibiKadouTime;
            }
        }
        return null;
    }

    private List<AT_KadouTime> aT_KadouTimes = Lists.newLinkedList();

    public AT_KadouTime createKadouTime() {
        AT_KadouTime aT_KadouTime = new AT_KadouTime();
        aT_KadouTime.setKadouTimeGroup(this);
        aT_KadouTime.setKadouTimeGroupCd(this.getKadouTimeGroupCd());
        getKadouTimes().add(aT_KadouTime);
        return aT_KadouTime;
    }

    @OneToMany(
        cascade       = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH },
        orphanRemoval = true
        )
    @JoinColumn (name = AT_KadouTime.KADOUTIMEGROUPCD, referencedColumnName = AT_KadouTimeGroup.KADOUTIMEGROUPCD, insertable = false, updatable = false)
    public List<AT_KadouTime> getKadouTimes() {
        return aT_KadouTimes;
    }

    public void setKadouTimes(List<AT_KadouTime> pKadouTimes) {
        aT_KadouTimes = pKadouTimes;
    }

    public AT_KadouTime getKadouTime(C_KadouTimeYoubiKbn pKadouTimeYoubiKbn, C_EigyoubiKbn pEigyoubiKbn) {
        for (AT_KadouTime kadouTime : getKadouTimes()) {
            if (kadouTime.getKadouTimeYoubiKbn().eq(pKadouTimeYoubiKbn) &&
                kadouTime.getEigyoubiKbn()      .eq(pEigyoubiKbn      )
                ) {
                return kadouTime;
            }
        }
        return null;
    }
}
