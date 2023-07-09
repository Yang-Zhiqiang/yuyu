CREATE VIEW HT_UketoriKouzaJyouhouVrf AS SELECT
     mosno ,         /* 申込番号 */
     uktkzsyubetukbn ,         /* 受取口座種別区分 */
     kouzainfoinputhoryuukbn ,         /* 口座情報入力保留区分 */
     kzsyuruikbn ,         /* 口座種類区分 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzkykdoukbn ,         /* 口座名義契約者同一人区分 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_UketoriKouzaJyouhouVrf_Z;