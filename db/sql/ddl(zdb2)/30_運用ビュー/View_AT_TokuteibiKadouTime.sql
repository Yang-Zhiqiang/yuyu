CREATE VIEW AT_TokuteibiKadouTime AS SELECT
     kadouTimeGroupCd ,         /* 稼働時間グループコード */
     kadouTimeSiteiYmd ,         /* 稼働時間指定年月日 */
     kadouTimeSiteiKbn ,         /* 稼働時間指定区分 */
     kadouTimeFrom1 ,         /* 稼働時間１（自） */
     kadouTimeTo1 ,         /* 稼働時間１（至） */
     kadouTimeFrom2 ,         /* 稼働時間２（自） */
     kadouTimeTo2 ,         /* 稼働時間２（至） */
     kadouTimeFrom3 ,         /* 稼働時間３（自） */
     kadouTimeTo3 ,         /* 稼働時間３（至） */
     kadouTimeFrom4 ,         /* 稼働時間４（自） */
     kadouTimeTo4 ,         /* 稼働時間４（至） */
     kadouTimeFrom5 ,         /* 稼働時間５（自） */
     kadouTimeTo5 ,         /* 稼働時間５（至） */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_TokuteibiKadouTime_Z;