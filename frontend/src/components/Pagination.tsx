import { useEffect, useState } from 'react';
import './Pagination.css';
interface PaginationProps {
	totalRecords: number;
	pageSize: number;
	pageIndex: number;
	onPageChanged: Function;
}

const Pagination = (props: PaginationProps) => {
	const [pages, setPages] = useState<number[]>([]);

	const computePages = () => {
		const array = [];
		for (
			let i = 1;
			i <= Math.ceil(props.totalRecords / props.pageSize);
			i++
		) {
			array.push(i);
		}
		setPages(array);
	};

	useEffect(() => {
		computePages();
	}, [props.totalRecords]);

	const renderPageOption = (pageNumber: number, index: number) => {
		return (
			<button
				key={index}
				className="btn-page mx-8"
				onClick={() => props.onPageChanged(pageNumber)}
			>
				{pageNumber}
			</button>
		);
	};

	return (
		<div>
			{pages.map((page: number, index: number) =>
				renderPageOption(page, index)
			)}
		</div>
	);
};

export default Pagination;
