package com.example.gdd_ideas.database.daos

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.performBlocking
import androidx.sqlite.SQLiteStatement
import com.example.gdd_ideas.database.entities.Proj
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ProjDao_Impl(
  __db: RoomDatabase,
) : ProjDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfProj: EntityInsertAdapter<Proj>

  private val __updateAdapterOfProj: EntityDeleteOrUpdateAdapter<Proj>
  init {
    this.__db = __db
    this.__insertAdapterOfProj = object : EntityInsertAdapter<Proj>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `tb_proj` (`idProj`,`projName`,`projDesc`,`fkUser`) VALUES (nullif(?, 0),?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Proj) {
        statement.bindLong(1, entity.idProj.toLong())
        statement.bindText(2, entity.projName)
        statement.bindText(3, entity.projDesc)
        statement.bindText(4, entity.fkUser)
      }
    }
    this.__updateAdapterOfProj = object : EntityDeleteOrUpdateAdapter<Proj>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `tb_proj` SET `idProj` = ?,`projName` = ?,`projDesc` = ?,`fkUser` = ? WHERE `idProj` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Proj) {
        statement.bindLong(1, entity.idProj.toLong())
        statement.bindText(2, entity.projName)
        statement.bindText(3, entity.projDesc)
        statement.bindText(4, entity.fkUser)
        statement.bindLong(5, entity.idProj.toLong())
      }
    }
  }

  public override fun save(proj: Proj): Long = performBlocking(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfProj.insertAndReturnId(_connection, proj)
    _result
  }

  public override fun update(proj: Proj): Int = performBlocking(__db, false, true) { _connection ->
    var _result: Int = 0
    _result += __updateAdapterOfProj.handle(_connection, proj)
    _result
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
