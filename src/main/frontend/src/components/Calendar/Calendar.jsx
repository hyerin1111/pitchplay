import React, { useState, useEffect } from "react";
import {
  format,
  addMonths,
  subMonths,
  startOfMonth,
  endOfMonth,
  startOfWeek,
  endOfWeek,
  addDays,
  isSameDay,
  isSameMonth,
  isWithinInterval,
} from "date-fns";
import "./Calendar.css";

const Calendar = ({ onSelect, allData }) => {
  const [currentMonth, setCurrentMonth] = useState(new Date());
  const [selectedRange, setSelectedRange] = useState({ start: null, end: null });
  const [isDropdownVisible, setIsDropdownVisible] = useState(false);

  // 날짜 선택 시 선택된 날짜 범위에 맞는 데이터를 필터링하여 부모 컴포넌트로 전달
  useEffect(() => {
    if (selectedRange.start && selectedRange.end) {

      const filtered = allData.filter((item) => {
        const itemDate = new Date(item.matchingDate);
        return isWithinInterval(itemDate, { start: selectedRange.start, end: selectedRange.end });
      });
      onSelect(filtered); // 부모 컴포넌트로 필터된 데이터 전달
    } else {
      onSelect([]); // 날짜가 선택되지 않았을 경우 빈 배열을 전달
    }
  }, [selectedRange]);

  const handlePrevMonth = () => {
    setCurrentMonth(subMonths(currentMonth, 1));
  };

  const handleNextMonth = () => {
    setCurrentMonth(addMonths(currentMonth, 1));
  };

  const handleDateClick = (day) => {
    if (!selectedRange.start || selectedRange.end) {
      setSelectedRange({ start: day, end: null });
    } else if (selectedRange.start && !selectedRange.end) {
      setSelectedRange((prevState) => {
        if (day < prevState.start) {
          return { start: day, end: prevState.start };
        }
        return { ...prevState, end: day };
      });
    }
  };

  const handleYearChange = (e) => {
    const newYear = e.target.value;
    setCurrentMonth((prev) => new Date(newYear, currentMonth.getMonth()));
    setIsDropdownVisible(false);
  };

  const handleMonthChange = (e) => {
    const newMonth = e.target.value;
    setCurrentMonth((prev) => new Date(currentMonth.getFullYear(), newMonth));
    setIsDropdownVisible(false);
  };

  const renderDays = () => {
    const startDate = startOfWeek(startOfMonth(currentMonth));
    const endDate = endOfWeek(endOfMonth(currentMonth));
    const days = [];
    let day = startDate;

    while (day <= endDate) {
      days.push(day);
      day = addDays(day, 1);
    }
    return days;
  };

  const years = Array.from({ length: 11 }, (_, i) => 2020 + i);
  const months = Array.from({ length: 12 }, (_, i) => i);

  return (
    <div className="calendar">
      <div className="header">
        <button onClick={handlePrevMonth}>이전</button>

        <div className="select-year-month">
          <span onClick={() => setIsDropdownVisible(!isDropdownVisible)}>
            {format(currentMonth, "yyyy년 MM월")}
          </span>

          {isDropdownVisible && (
            <div className="dropdown">
              <div className="dropdown-content">
                <select onChange={handleYearChange} value={currentMonth.getFullYear()}>
                  {years.map((year) => (
                    <option key={year} value={year}>
                      {year}년
                    </option>
                  ))}
                </select>
                <select onChange={handleMonthChange} value={currentMonth.getMonth()}>
                  {months.map((month) => (
                    <option key={month} value={month}>
                      {month + 1}월
                    </option>
                  ))}
                </select>
              </div>
            </div>
          )}
        </div>

        <button onClick={handleNextMonth}>다음</button>
      </div>

      <div className="selected-range">
        <input
          type="text"
          readOnly
          value={selectedRange.start ? format(selectedRange.start, "yyyy-MM-dd") : ""}
          placeholder="시작일"
          onClick={() => setSelectedRange({ ...selectedRange, start: null })}
        />
        {/* 종료일 입력 */}
        <input
          type="text"
          readOnly
          value={selectedRange.end ? format(selectedRange.end, "yyyy-MM-dd") : ""}
          placeholder="종료일"
          onClick={() => setSelectedRange({ ...selectedRange, end: null })}
        />
      </div>

      <div className="calendar-grid">
        <div className="week-days">
          {["일", "월", "화", "수", "목", "금", "토"].map((day) => (
            <div key={day} className="day-name">
              {day}
            </div>
          ))}
        </div>

        <div className="dates">
          {renderDays().map((day, index) => {
            const isSelectedStart = isSameDay(day, selectedRange.start);
            const isSelectedEnd = isSameDay(day, selectedRange.end);
            const isInRange =
              selectedRange.start &&
              selectedRange.end &&
              isWithinInterval(day, {
                start: selectedRange.start,
                end: selectedRange.end,
              });

            return (
              <div
                key={index}
                className={`date ${isSameMonth(day, currentMonth) ? "" : "disabled"} ${
                  isSelectedStart ? "selected-start" : ""
                } ${isSelectedEnd ? "selected-end" : ""} ${
                  isInRange && !isSelectedStart && !isSelectedEnd ? "in-range" : ""
                }`}
                onClick={() => handleDateClick(day)}
              >
                {format(day, "d")}
              </div>
            );
          })}
        </div>
      </div>
    </div>
  );
};

export default Calendar;
