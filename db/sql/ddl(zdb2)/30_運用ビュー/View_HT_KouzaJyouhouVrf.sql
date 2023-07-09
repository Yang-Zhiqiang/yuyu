CREATE VIEW HT_KouzaJyouhouVrf AS SELECT
     mosno ,         /* 申込番号 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     kzkykdoukbn ,         /* 口座名義契約者同一人区分 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     sinkeizkkbn ,         /* 新規継続区分 */
     hbcmnt ,         /* 不備コメント */
     syuudaikocd ,         /* 収納代行社コード */
     kouzakakuniniraikbn ,         /* 口座確認依頼区分 */
     kouzakakuniniraiymd ,         /* 口座確認依頼日 */
     kouzajyouhounyuuryokuymd ,         /* 口座情報入力日 */
     kzhuritourokuhoukbn ,         /* 口座振替登録方法区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_KouzaJyouhouVrf_Z;