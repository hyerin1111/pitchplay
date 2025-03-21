import React from 'react';
import styled from 'styled-components';

const Button = styled.button`
  background: none;
  border: none;
  padding: 0;
  cursor: pointer;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  outline: none;
  box-shadow: none;

  &:focus {
    outline: none;
    box-shadow: none;
  }
`;

const SvgIcon = styled.svg`
  width: 60px;
  height: 60px;
  fill: #5F6379;
  transition: fill 0.3s ease;

  path {
    fill: inherit;
  }

  ${Button}:hover & {
    fill: #275B1A;
  }
`;

function CircularButton({ onClick, gridArea }) {
  return (
    <Button onClick={onClick} style={{ gridArea }}>
      <SvgIcon viewBox="0 0 60 60" xmlns="http://www.w3.org/2000/svg">
        <path d="M0 30C0 13.459 13.459 0 30 0C46.541 0 60 13.459 60 30C60 46.541 46.541 60 30 60C13.459 60 0 46.541 0 30ZM55.002 30C55.002 16.2129 43.7871 4.99805 30 4.99805C16.2129 4.99805 4.99805 16.2129 4.99805 30C4.99805 43.7871 16.2129 55.002 30 55.002C43.7871 55.002 55.002 43.7871 55.002 30Z" />
        <path d="M18.7505 27.4976C18.7505 26.8589 18.9966 26.2202 19.4829 25.728C20.4614 24.7495 22.0435 24.7495 23.0161 25.728L30.0005 32.7124L36.9849 25.7339C37.9634 24.7554 39.5454 24.7554 40.5181 25.7339C41.4966 26.7124 41.4966 28.2944 40.5181 29.2671L31.77 38.0151C30.7915 38.9937 29.2095 38.9937 28.2368 38.0151L19.4829 29.2671C18.9966 28.7808 18.7505 28.1362 18.7505 27.4976Z" />
      </SvgIcon>
    </Button>
  );
}

export default CircularButton;