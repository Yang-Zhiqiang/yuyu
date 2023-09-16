package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.mapping.GenIT_BAK_AnsyuRireki;


/**
 * 案内収納履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_AnsyuRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_AnsyuRireki<br />
 * @see     PKIT_BAK_AnsyuRireki<br />
 * @see     QIT_BAK_AnsyuRireki<br />
 * @see     GenQIT_BAK_AnsyuRireki<br />
 */
@Entity
public class IT_BAK_AnsyuRireki extends GenIT_BAK_AnsyuRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_AnsyuRireki() {
    }

    public IT_BAK_AnsyuRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,C_NyknaiyouKbn pNyknaiyoukbn,BizDateYM pJyuutouym,Integer pAnnaino) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pNyknaiyoukbn,pJyuutouym,pAnnaino);
    }

    public IT_BAK_AnsyuRireki(String pSyono,String pTrkssikibetukey,C_NyknaiyouKbn pNyknaiyoukbn,BizDateYM pJyuutouym,Integer pAnnaino) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pNyknaiyoukbn,pJyuutouym,pAnnaino);
    }


    private IT_BAK_AnsyuKihon iT_BAKAnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_AnsyuRireki.KBNKEY  , referencedColumnName=IT_BAK_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_AnsyuRireki.SYONO  , referencedColumnName=IT_BAK_AnsyuKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_AnsyuRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_AnsyuKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_AnsyuKihon getBAKAnsyuKihon() {
        return iT_BAKAnsyuKihon;
    }

    public void setBAKAnsyuKihon(IT_BAK_AnsyuKihon pIT_BAK_AnsyuKihon) {
        this.iT_BAKAnsyuKihon = pIT_BAK_AnsyuKihon;
    }

}

