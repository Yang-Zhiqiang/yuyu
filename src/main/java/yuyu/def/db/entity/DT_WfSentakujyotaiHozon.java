package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenDT_WfSentakujyotaiHozon;


/**
 * ワークフロー選択状態保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenDT_WfSentakujyotaiHozon} の JavaDoc を参照してください。<br />
 * @see     GenDT_WfSentakujyotaiHozon<br />
 * @see     PKDT_WfSentakujyotaiHozon<br />
 * @see     QDT_WfSentakujyotaiHozon<br />
 * @see     GenQDT_WfSentakujyotaiHozon<br />
 */
@Entity
public class DT_WfSentakujyotaiHozon extends GenDT_WfSentakujyotaiHozon {

    private static final long serialVersionUID = 1L;

    public DT_WfSentakujyotaiHozon() {
    }

    public DT_WfSentakujyotaiHozon(String pUserId,String pSubSystemId) {
        super(pUserId,pSubSystemId);
    }



}

