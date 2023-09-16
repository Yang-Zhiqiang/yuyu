package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_SequenceValue;
import yuyu.def.db.mapping.GenAT_SequenceValue;
import yuyu.def.db.meta.GenQAT_SequenceValue;
import yuyu.def.db.meta.QAT_SequenceValue;

/**
 * 連番値管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_SequenceValue} の JavaDoc を参照してください。
 * @see     GenAT_SequenceValue
 * @see     PKAT_SequenceValue
 * @see     QAT_SequenceValue
 * @see     GenQAT_SequenceValue
 */
@Entity
public class AT_SequenceValue extends GenAT_SequenceValue {

    private static final long serialVersionUID = 1L;

    public AT_SequenceValue() {
    }

    public AT_SequenceValue(String pId, String pKeys) {
        super(pId, pKeys);
    }

    private AS_Sequence aS_Sequence;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name = AT_SequenceValue.ID, referencedColumnName = AS_Sequence.ID, insertable=false, updatable=false)
    public AS_Sequence getSequence(){
        return aS_Sequence;
    }

    public void setSequence(AS_Sequence pAS_Sequence){
        aS_Sequence = pAS_Sequence;
    }
}
