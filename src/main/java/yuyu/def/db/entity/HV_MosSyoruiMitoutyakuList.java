package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.mapping.GenHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.GenQHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.QHV_MosSyoruiMitoutyakuList;
import jp.co.slcs.swak.date.BizDate;

/**
 * 申込書類未到着リスト情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHV_MosSyoruiMitoutyakuList} の JavaDoc を参照してください。
 * @see     GenHV_MosSyoruiMitoutyakuList
 * @see     PKHV_MosSyoruiMitoutyakuList
 * @see     QHV_MosSyoruiMitoutyakuList
 * @see     GenQHV_MosSyoruiMitoutyakuList
 */
@Entity
public class HV_MosSyoruiMitoutyakuList extends GenHV_MosSyoruiMitoutyakuList {

    private static final long serialVersionUID = 1L;

    public HV_MosSyoruiMitoutyakuList() {
    }

    public HV_MosSyoruiMitoutyakuList(BizDate pSyoriYmd,String pItirenno) {
        super(pSyoriYmd,pItirenno);
    }

}
