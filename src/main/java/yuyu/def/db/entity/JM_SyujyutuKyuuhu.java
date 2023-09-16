package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenJM_SyujyutuKyuuhu;


/**
 * 手術給付マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_SyujyutuKyuuhu} の JavaDoc を参照してください。<br />
 * @see     GenJM_SyujyutuKyuuhu<br />
 * @see     PKJM_SyujyutuKyuuhu<br />
 * @see     QJM_SyujyutuKyuuhu<br />
 * @see     GenQJM_SyujyutuKyuuhu<br />
 */
@Entity
public class JM_SyujyutuKyuuhu extends GenJM_SyujyutuKyuuhu {

    private static final long serialVersionUID = 1L;

    public JM_SyujyutuKyuuhu() {
    }

    public JM_SyujyutuKyuuhu(String pSyujyutubunruicd,String pSyouhncd,Integer pSyouhnsdno,String pKyuuhucd,BizDate pSyujyututekiyoukkanfrom,BizDate pSyujyututekiyoukkanto) {
        super(pSyujyutubunruicd,pSyouhncd,pSyouhnsdno,pKyuuhucd,pSyujyututekiyoukkanfrom,pSyujyututekiyoukkanto);
    }



}

