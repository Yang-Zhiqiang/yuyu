CREATE VIEW IM_ZennouMkkpSampleList AS SELECT
     zennoutoukeilistkbn ,         /* 前納統計リスト区分 */
     zennoukbn ,         /* 前納区分 */
     kbnkeirisegcd ,         /* 区分経理用セグメントコード */
     znnmkkpkssamplekslsttitle ,         /* 前納未経過Ｐ検証サンプルリストタイトル */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IM_ZennouMkkpSampleList_Z;