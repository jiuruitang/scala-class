package com.datascience.education.tutorial.lecture4

import org.scalatest._
import org.scalatest.{FunSuite, Matchers}

import scala.Option
import scala.Some
import scala.None

import java.util.UUID

import scala.language.implicitConversions

import com.datascience.education.tutorialCommon.lecture4.{EmployeesSpec => CommonEmployeesSpec}

import Employees._

import com.datascience.education.tutorialCommon.lecture4.EmployeeTypeclass
import com.datascience.education.tutorialCommon.lecture4.EmployeesTypeclass

object EmployeesSpec {
  implicit def employeeTypeclass(e: Employee): EmployeeTypeclass[Email] =
    new EmployeeTypeclass[Email] {
      val id = e.id
      val email = e.email
    }

  implicit def employeesTypeclass:
      EmployeesTypeclass[Employee, Email] =
    new EmployeesTypeclass[Employee, Email] {
      val prianna: Employee = Employees.prianna
      val peter: Employee = Employees.peter
      val chrisId: UUID = Employees.chrisId
      def employeeEmail(id: UUID): Option[Email] =
      Employees.employeeEmail(id)
    }
}

import EmployeesSpec._

// uncomment when ready to test
// class EmployeesSpec
//     extends CommonEmployeesSpec()(employeeTypeclass, employeesTypeclass)

